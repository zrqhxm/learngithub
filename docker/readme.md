## 使用CentOS7

### 安装docker

```
yum install docker
```

### 启动docker

````
systemctl start docker

#启动报错：Job for docker.service failed because the control process exited with error code
解决方式：修改docker配置文件：vim  /etc/sysconfig/docker
把OPTIONS一行改为：OPTIONS='--selinux-enabled=false --log-driver=journald --signature verification=false'
再启动：systemctl start docker 就可以了
````

### 基本命令

```
systemctl start docker  #启动docker
systemctl stop docker   #停止docker
systemctl restart docker  #重启docker
systemctl status docker   #查看docker状态
systemctl enable docker   #开机启动
docker info   #查看docker概要信息
docker --help  #查看docker帮助文档
docker search tomcat #从网络中搜索镜像 如:tomcat
```

### 列出镜像

```
docker images   #镜像存储的位置 /var/lib/docker
```

### 拉取镜像加速器

```
编辑该文件：vi /etc/docker/daemon.json
{
"registry-mirrors": ["https://docker.mirrors.ustc.edu.cn"]
}
```

### 拉取镜像

```
docker pull centos:7  #拉取centos7
```

### 删除镜像

```
docker rmi xxx #删除指定镜像 IMAGE_ID
docker rmi `docker images -q` #删除所有镜像  注意：不是引号，是撇号 tab上面哪那个键
docker images -q #列出所有镜像的IMAGE_ID
```

### 容器查看

```
docker ps   #查看正在运行的容器
docker ps -a   #查看所有的容器(启动过的历史容器)
docker ps -l   #查看最后一次运行容器
docker pa -f status=exited  #查看你停止的容器
```

### 创建和启动容器

```

```

