学习笔记
1.主从配置
从服务器配置文件:修改项slaveof <masterip> <masterport>，改为主服务器的ip和端口
2.集群配置
1)修改配置文件，修改配置项 cluster-enabled yes
2)redis-cli --cluster create --cluster-replicas 1 集群节点ip:集群端口 集群节点ip:集群端口 集群节点ip:集群端口
3.配置哨兵
修改配置文件，修改配置项 sentinel monitor 主节点ip 主节点端口