应用异常监控排查-应急数据收集：
    1. 各服务器top命令截图 
	2. jstack [pid] > /[pid].tdump
		附：pid为进程id，可通过ps或jps等查看
	3. druid等对异常请求截图 
	4. 慢sql截图  
	5. 应用业务日志保存
	


相关章节内容摘抄自
	《高性能Linux服务器运维实战》高俊峰编著