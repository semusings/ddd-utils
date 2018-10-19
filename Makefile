build:
	mvn clean install
copy-docs:
	cp -R ddd-utils-docs/target/contents/reference/htmlsingle/* docs/
gen-docs:
	@read -p "Revision: " revision; \
	mvn clean package -Pfull -Drevision=$${revision} -e && \
	$(MAKE) copy-docs
deploy:
	@read -p "Revision: " revision; \
	mvn clean deploy -Prelease,central,full -Drevision=$${revision} -e && \
	$(MAKE) copy-docs
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
