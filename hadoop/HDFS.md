概念：文件系统，存储文件，通过目录树定位文件；分布式，有很多服务器联合起来实现功能，集群中服务器哟各自的角色。

适合一次写入，多次读取的场景，且不支持文件的修改。适合用来做数据分析，不适合用来做网盘。



优点：

​	高容错性

​	适合大数据处理

​	流式数据访问

​	可构建在廉价机器上，通过多副本机制，提高可靠性