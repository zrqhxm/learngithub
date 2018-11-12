新手学习github的使用

第一次将本地文件readme.md推送到github上
  1.git add "readme.md"
  2.git commit -m "新建readme.md文档"
  3.git remote add origin git@github.com:zrqhxm/learngithub.git
  4.git push origin master
通过以上四步后（ssh-keygen -t rsa  -C  "your email@.com"已完成），在这里可以看到这个readme.md文件

将github远程仓库更新的资源拉取到本地
  git pull origin master  -- master是主节点或分支节点的



命令：

```
ssh-keygen -t rsa -C "xxxx@xx.com"  --生成密钥公钥  将id_rsa.pub内容复制到git网页中

ssh -T git@github.com    --测试公钥配置是否成功，和git服务器连接

git add "文件名"

git add .

git commit -m "提交说明"

git push origin master   --上传到远端git服务器

git clone https://xxxxxx   --克隆项目到本地

git pull origin master  -- master是主节点或分支节点的

```






