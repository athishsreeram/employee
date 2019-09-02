Employee SBA App

mvn clean install

docker build -t emp-manual-build .

docker images

docker run -p 8080:8082 emp-manual-build