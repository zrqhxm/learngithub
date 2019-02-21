### 查看内存使用情况

```shell
free -m
free -h
free
```

### 清理内存

```shell
echo 1 > /proc/sys/vm/drop_caches
```

### 内存条数

```shell
dmidecode |grep -A16 "Memory Device$"
```

