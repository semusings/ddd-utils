build:
	mvn clean install
deploy:
	mvn clean deploy -Prelease,central