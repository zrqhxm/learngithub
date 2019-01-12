反向代理

```
 通过www.zrq.com:80 访问到192.168.25.141:8080/index.html
 nginx代理192.168.25.141:8080
 upstream tomcat-portal {
	   server 192.168.25.141:8080;
    }
    server {
        listen       80;
        server_name  www.zrq.com;   
        location / {
            proxy_pass   http://tomcat-portal;
            index  index.html;
        }
    }
```

负载均衡
 

       # weight=2 权重的配置 nginx默认是轮询策略 
        upstream tomcat-portal2 {
    	   server 192.168.25.141:8080;
    	   server 192.168.25.142:8080 weight=2;
    	   server 192.168.25.143:8080;
        }
        
        server {
          listen       80;
          server_name  www.zrq.com;
        location / {
            proxy_pass   http://tomcat-portal2;
            index  index.html;
        }
        
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
