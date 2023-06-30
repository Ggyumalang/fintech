#!/bin/sh

# Setting Versions
# shellcheck disable=SC2034
VERSION='1.0.1'

cd ..
./gradlew clean build -x test

# shellcheck disable=SC2006
ROOT_PATH=`pwd`
echo $ROOT_PATH

echo 'api docker image build... Start'
cd $ROOT_PATH/api && docker build -t api:$VERSION .
echo 'api docker image build... Finish'

echo 'consumer docker image build... Start'
cd $ROOT_PATH/consumer && docker build -t consumer:$VERSION .
echo 'consumer docker image build... Finish'

echo 'css docker image build... Start'
cd $ROOT_PATH/css && docker build -t css:$VERSION .
echo 'css docker image build... Finish'

echo 'nginx docker image build... Start'
cd $ROOT_PATH/nginx && docker build -t nginx:$VERSION .
echo 'nginx docker image build... Finish'