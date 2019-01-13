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
#创建交互式容器  创建后就立即进入容器，退出就立即关闭容器
docker run -it --name=mycentos centos:7 /bin/bash #创建
exit #退出

#创建守护式容器  守护进程，后台运行
docker run -di --name=mycentos2 centos:7 #创建
exit #退出 容器还在运行

#停止容器
docker stop $CONTAINER_NAME/ID
docker stop mycentos

#启动已运行过的容器
docker start $CONTAINER_NAME/ID
docker start mycentos

##容器创建的基本参数
* 创建容器命令：docker run
* -i：表示运行容器
* -t：表示容器启动后会进入其命令行。加入这两个参数后，容器创建就能登录进去。即分配一个伪终端
* --name :为创建的容器命名
* -v：表示目录映射关系（前者是宿主机目录，后者是映射到宿主机上的目录），可以使用多个－v做多个目录或文件映射。注意：最好做目录映射，在宿主机上做修改，然后共享到容器上
* -d：在run后面加上-d参数,则会创建一个守护式容器在后台运行（这样创建容器后不会自动登录容器，如果只加-i -t两个参数，创建后就会自动进去容器）
* -p：表示端口映射，前者是宿主机端口，后者是容器内的映射端口。可以使用多个－p做多个端口映射
```

### 文件拷贝

```
#注：容器键无法相互拷贝文件，需以宿主机作为桥梁
docker cp 需要拷贝的文件或目录 容器名称：容器目录  #宿主机中的文件拷贝到容器中
docker cp testfile mycentos:/usr/local

docker cp 容器名称：容器目录 需要拷贝的文件或目录
docker cp mycentos:/usr/local testfile
```

### 目录挂载

```
#将宿主机的目录与容器内的目录进行映射，这样我们就可以通过修改宿主机某个目录的文件从而去影响容器
#语法：创建容器 添加-v参数 后边为   宿主机目录:容器目录
docker run -di -v /usr/local/springboot:/usr/local/springboot --name=mycentos2 centos:7

#共享多级目录是会出现权限不足的情况 需要在创建容器是添加权限参数
docker run -di --name=mycentos2 --privileged=true centos:7
```

### 查看容器IP

```
docker inspect mycentos2  #方式一
docker inspect --format='{{.NetworkSettings.IPAddress}}' mycentos2  #方式二
```

### 删除容器

```
docker rm $CONTAINER_ID/NAME  #删除容器
docker rmi $IMAGE_ID  #删除镜像

docker rmi `docker images -q` #删除所有镜像
docker rm `docker ps -a -q`  #删除所有容器
```

### MySQL容器

```
docker pull mysql #拉取镜像
docker run -di --name my_mysql -p 33306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql # -p代表端口映射 宿主机端口：容器运行端口  -e代表添加环境变量 
docker exec -it my_mysql /bin/bash #进入容器
docker -u root -p  #登录mysql
```

### tomcat容器

```
docker pull tomcat:7 -jre7
```

### nginx容器

```
docker pull nginx
docker run -di --name=my_nginx -p 80:80 nginx
```

### 容器保存为镜像

```
docker commit my_nginx mynginx  #将nginx保存为自己的镜像
```

### 镜像备份

```
docker save -o mynginx.tar mynginx  #打包自己的镜像
```

### 镜像恢复

```
docker load -i mynginx.tar
```

