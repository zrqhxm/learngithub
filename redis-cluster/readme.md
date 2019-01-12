**redis集群搭建**

```
#编译redis  需要进入redis源码文件夹中    make distclean这是清除的命令
make

#安装redis实例到redis-1文件夹
make install PREFIX=/usr/local/redis-cluster/redis-1

#集群中需要将redis.conf里cluster-enabled yes 前的注释去掉(632行)，表示开启集群

#启动redis实例命令  
./redis-server redis.conf

#上传redis-3.0.0.gem 并且安装ruby脚本用于的搭建集群
gem install rediis-3.0.0.gem

#进入redis源码目录中的src下执行，配合使用ruby脚本搭建集群
./redis-trib.rb create --replicas 1 192.168.102.137:7001 192.168.102.137:7002 192.168.102.137:7003 192.168.102.137:7004 192.168.102.137:7005 192.168.102.137:7006

#连接集群节点
./redis-cli -p 主机ip -p 端口（集群中任意端口） -c
./redis-cli -p 192.168.102.137 -p 7001 -c

#关闭节点
./redis-cli -p 端口 shutdown
```

