apt update -y

apt install ca-certificates curl gnupg lsb-release

mkdir /etc/apt/demokeyrings

curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/demokeyrings/demodocker.gpg

 echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/demokeyrings/demodocker.gpg] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list

apt update -y

apt install docker-ce docker-ce-cli containerd.io docker-compose-plugin

echo "tienes la versión: "
docker --version; docker compose version;ctr version
