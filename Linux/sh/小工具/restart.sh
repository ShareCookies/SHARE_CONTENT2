#! /bin/sh
#check for root user
if [ "$(id -u)" -ne 0 ] ; then
        echo "You must run this script as root. Sorry!"
        echo "请用root用户执行这个命令!"
        exit 1
fi

kill -9 $(ps -aef | grep port=6051 | grep -v grep | awk '{print $2}')
echo ''> nohup.out

nohup java -Xmx800m -Xms800m -jar -Dspring.profiles.active=dev -Dfile.encoding=UTF-8 -Dserver.port=6051 test.jar  >> nohup.log 2>&1 &

echo "**********************************"
echo "***         start...           ***"
echo "***      程序正在启动...       ***"
echo "**********************************"
echo "use 'tail -f nohup.out' to see the log ,if there is no error losg, that is be OK!"
echo "用'tail -f nohup.out' 查看实时日志,如果没有错,就是正常的!"
echo "可用按回车,继续!"
