docker run -d \
--name fintech-mysql \
--network docker_fintech \
-e MYSQL_ROOT_PASSWORD="fintech" \
-e MYSQL_USER="fintech" \
-e MYSQL_PASSWORD="fintech" \
-e MYSQL_DATABASE="fintech" \
-p 3306:3306 \
mysql:latest
