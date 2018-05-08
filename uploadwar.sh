# please cd to {your_fscomunity_home_directory}/
mvn package -Dmaven.test.skip=true
scp provider/target/fscommunity.provider.war fs:/home/worker/deploy/release/fscommunity.provider/ROOT