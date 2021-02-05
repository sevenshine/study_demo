###启动后，报错，cannot connect to redis
####解决
不知道什么鬼，弄了一堆的解决方案，最后解决了，然后回测，妈蛋的原先的问题复现不了了
* 加配置：spring.redis.timeout=30s 超时时间设置
* 【这个最有可能】启动的时候不直接双击启动，命令行启动：./redis-server.exe redis.windows.confhuo 或者直接./redis-server.exe
* redis.windows.conf进行密码配置（requirepass=123456），
同步配置中加上密码（spring.redis.password=123456）

最终：问题解决了，然后解决方案不知道是哪个出了问题。。。尴尬