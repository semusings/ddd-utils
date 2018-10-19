build:
	mvn clean install
deploy:
	mvn clean deploy -Prelease,central
staging:
	mvn clean deploy -Pcentral
gen-gpg:
	gpg --full-generate-key
export-gpg:
	cd ${HOME}/.gnupg && \
	gpg --export-secret-keys -o secring.gpg
publish-gpg-key:
	gpg -K
	@read -p "Gpg Key Id: " keyId; \
	gpg --send-keys --keyserver keyserver.ubuntu.com $${keyId}
gen-docs:
	mvn clean package -Pfull
