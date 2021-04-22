#!/bin/bash
INI_FILE="/data/rjmanage/config.ini"
MSG=""
maxItem=12
defaultPath="/data2/jar_back"

 readIni()
{
        Key=$1
        Model=$2
        Configfile=$3
        ReadINI=`awk -F '=' '/\['$Model'\]/{a=1}a==1&&$1~/'$Key'/{print $2;exit}' $Configfile`
        echo "$ReadINI"
}

print_usage() {
    echo    ""
    echo    "用法：./rjmanage.sh [选项] [参数]"
    echo -e "\e[1;34m选项说明：\e[m"
    printf  "%-15s %-30s\n" list 列出本地所有模块信息
    printf  "%-15s %-30s\n" status 查看模块运行状态
    printf  "%-15s %-30s\n" restartall 所有本地模块重新启动
    printf  "%-15s %-30s\n" "restart A,B,C" 重启指定本地模块,用英文逗号分割,模块名为list选项所列出的code
    printf  "%-15s %-30s\n" packall "打包所有模块,把需现场部署的jar文件整理到指定目录"
    printf  "%-15s %-30s\n" "" "默认目录:/data2/jar_back,创建以当天日期为名的目录,如:20200920_01"
    printf  "%-15s %-30s\n" "pack A,B,C" "打包指定模块,把需现场部署的jar文件整理到指定目录"
    printf  "%-15s %-30s\n" "" "默认目录:/data2/jar_back,创建以当天日期为名的目>录,如:20200920_01"
    printf  "%-15s %-30s\n" stopall 停止本地所有模块
    printf  "%-15s %-30s\n" "stop A,B,C" 停止指定本地模块,用英文逗号分割,模块名为list选项所列出的code
    printf  "%-15s %-30s\n" help 查看帮助信息

} # end print_usage

check(){
    local module=$1
    local moduleName=$2
    local name=$3
    value=$4
    value=${value// /}
    if [ -n "${value}" ] ; then
        return 0
    else
    MSG=$MSG"\033[41;37m没找到[${module}:${moduleName}]的[${name}值]\033[0m\n"
    return 1
    fi
} # check param

print_result(){
    echo ""
    echo -e "\e[1;34m======结果======\e[m"
    echo "运行模块:$1"
    echo -e "${MSG}"
} # end print_result

restart () {
    modulesStr=$1
    array=(${modulesStr//,/ })
    echo "array:${array[@]}"
    for module in ${array[@]}
    do
        port=`readIni "port" "$module" "$INI_FILE"`
    name=`readIni "name" "$module" "$INI_FILE"`
    jvms=`readIni "jvms" "$module" "$INI_FILE"`
    path=`readIni "path" "$module" "$INI_FILE"`
        active=`readIni "active" "$module" "$INI_FILE"`
        jar=`readIni "jar" "$module" "$INI_FILE"`
    check "$module" "$name" "port" "$port"
    r1=$?
    check "$module" "$name" "jvms" "$jvms"
    r2=$?
    check "$module" "$name" "path" "$path"
        r3=$?
    check "$module" "$name" "active" "$active"
        r4=$?
    check "$module" "$name" "jar" "$jar"
        r5=$?
    addResult=$[$r1+$r2+$r3+$r4+$r5]
    if [ $addResult -le 0 ] ; then
        echo '' > ${path}/nohup.log
            kill="kill -9 \$(ps -aef | grep port=${port} | grep -v grep | awk '{print \$2}')"
            echo "kill:${kill}"
            eval $kill
            start="nohup java ${jvms} -jar -Dspring.profiles.active=${active} -Dfile.encoding=UTF-8 -Dserver.port=${port} ${path}/${jar} >> ${path}/nohup.log 2>&1 &"
        echo "start: $start"
        eval "cd ${path}"
        eval $start
        MSG=$MSG"[${module}模块]::启动中\n"
    fi
    done
    print_result "$modulesStr"
} # end restart

stop(){
    modulesStr=$1
    array=(${modulesStr//,/ })
    echo "array:${array[@]}"
    for module in ${array[@]}
    do
        port=`readIni "port" "$module" "$INI_FILE"`
        path=`readIni "path" "$module" "$INI_FILE"`
        check "$module" "$name" "port" "$port"
        r1=$?
        check "$module" "$name" "path" "$path"
        r3=$?
        addResult=$[$r1+$r3]
        if [ $addResult -le 0 ] ; then
            echo '' > ${path}/nohup.log
            kill="kill -9 \$(ps -aef | grep port=${port} | grep -v grep | awk '{print \$2}')"
            echo "kill:${kill}"
            eval $kill
            MSG=$MSG"[${module}模块]::停止中\n"
        fi
    done
    print_result "$modulesStr"
} # end stop

stopall () {
    echo "stopall:"
    modulesStr=`listModules`
    stop "$modulesStr"
} # end restartall

# get all module'name from config.ini
listModules () {
    i=0
    modules=()
    while read -r line ; do
        result1=${line:1}
        result2=${result1%%]*}
        #echo "module${i}: ${result2}"
        modules[$i]=$result2
        let i++
    done < <(grep -E '\[*\]' "$INI_FILE")

    modulesStr=$(IFS=$','; echo "${modules[*]}")
    echo "$modulesStr"
} # end listModules

 list () {
    printf "\e[1;34m%-10s\e[m \e[1;34m%-20s\e[m \e[1;34m%-10s\e[m \e[1;34m%-30s\e[m\n" code name port jar
    modulesStr=`listModules`
    array=(${modulesStr//,/ })
    for module in ${array[@]}
    do
    name=`readIni "name" "$module" "$INI_FILE"`
    port=`readIni "port" "$module" "$INI_FILE"`
    jar=`readIni "jar" "$module" "$INI_FILE"`
    printf "%-10s %-20s %-10s %-30s\n" ${module} ${name} ${port} ${jar}
    done

} # end list

 restartall () {
    echo "restartall"
    modulesStr=`listModules`
    restart "$modulesStr"
} # end restartall

status(){
    modulesStr=`listModules`
    array=(${modulesStr//,/ })
    for module in ${array[@]}
    do
    name=`readIni "name" "$module" "$INI_FILE"`
    port=`readIni "port" "$module" "$INI_FILE"`
    r=$(echo >/dev/tcp/localhost/${port} && echo 'ok')
        if [ ''${r} == 'ok' ] ; then
            out="[${module}:${name}] \033[32m [ok] \033[0m\n"
            echo -e ""$out
            MSG=$MSG$out
        else
            out="[${module}:${name}] \033[41;37m [error] \033[0m\n\r"
            echo -e ""$out
            MSG=$MSG$out
        fi
    done
    print_result "$modulesStr"
} # status


path(){
    module=$1
    path0=$2
    time=`date +%Y%m%d`
    path1="${defaultPath}/${time}_"

## not dir create
    i=1
    if [ ! -d ${path1}$i ]
    then
    ## return path
        echo "${path1}$i"
    else
        tooLarge=false
        while [ -d ${path1}$i ]
        do
            i=$[$i+1]
            if [ $i -gt ${maxItem} ]
            then
                tooLarge=true
                break;
            fi
        done
        if [ $tooLarge == "true" ]
        then
        echo "NULL"
            MSG=$MSG"序号值为${i},max is:${maxItem}, 请删除一些文件夹\n"
        else
            echo "${path1}$i"
        fi
    fi

} # pack jar
pack(){
    local modulesStr=$1
    local path0=$2
    echo -e "\e[1;34m打包模块：\e[m${modulesStr}"
    lastPath=`path "${modulesStr}" "${path0}"`
    path "${modulesStr}" "${path0}" >>/dev/null
    echo -e "\e[1;34m打包目录：\e[m${lastPath}"
    echo "正在打包......"
    if [ ${lastPath} != "NULL" ]
    then
        array=(${modulesStr//,/ })
    mkdir ${lastPath}
        for module in ${array[@]}
        do
            path=`readIni "path" "$module" "$INI_FILE"`
            jar=`readIni "jar" "$module" "$INI_FILE"`
            check "$module" "$name" "path" "$path"
            r3=$?
            check "$module" "$name" "jar" "$jar"
            r5=$?
            local moduleDir=`basename ${path}`

            if [ -n "${moduleDir}" ] ; then
                r7=0
            else
                r7=1
                MSG=$MSG"\033[41;37m[${module}:${moduleName}]的[${path}值],取目录有问题！\033[0m\n"
            fi
            addResult=$[$r3+$r5+$r7]
            if [ $addResult -le 0 ] ; then
                mkdir ${lastPath}/${moduleDir}
                echo "正在复制：${path}/${jar} --> ${lastPath}"
                \cp ${path}/${jar} ${lastPath}/${moduleDir}
            fi
    done
    cd ${defaultPath}
    dirName=`basename ${lastPath}`
    echo "正在压缩文件......"
    tar -zcf "${dirName}.tar" "${dirName}"
    MSG=$MSG"\e[1;34m完成打包\e[m\n"
    fi
}

packall () {
    modulesStr=`listModules`
    pack "$modulesStr" "$defaultPath"
} # end packall

if [ $# -eq 0 ]; then
    print_usage
    exit
fi

if [ $# -eq 1 ]; then
    case "$1" in
    restartall)
        restartall
        shift
        ;;
    list)
        list
        shift
        ;;
    status)
        status
        shift
        ;;
    stopall)
        stopall
        shift
        ;;
    packall)
        packall
        echo -e "${MSG}"
        shift
        ;;
    help)
        print_usage
        shift
        ;;
    *)
        print_usage
        shift
        ;;
    esac
    exit
fi

if [ $# -eq 2 ]; then
    case "$1" in
    restart)
        restart "$2"
        shift
        ;;
    stop)
        stop "$2"
        shift
        ;;
    pack)
        modulesStr=$2
        pack "${modulesStr}" "${defaultPath}"
        echo -e "${MSG}"
        shift
        ;;
    *)
        print_usage
        shift
        ;;
    esac
    exit
fi

print_usage
