# bKash-passthrough-mw


## Dev Environment Readiness

#### Prerequisite:

1. AWS-CLI (V1)
2. Docker
3. npm (v6.11.3)
4. node (v12.12.0)
5. vue (v2.6)

### Require HOST entry  

1. localhost:8001/                            => dynamodb-admin 
2. localhost:8091/                            => backend
3. localhost:8080/passthrough-middleware/     => frontend

#### To run localstack, configuring DynamoDB Admin UI:


###### Create mock aws credentials file (method 1):

```
$ sudo touch ~/.aws/credentials
$ sudo nano ~/.aws/credentials
```

Put below lines in the file ~/.aws/credentials and save it.
```
[default]
aws_access_key_id = fakeMyKeyId
aws_secret_access_key = fakeSecretAccessKey
```
To view aws configuration
```
$sudo aws configure list
```
Create mock aws config file:
```
$ sudo touch  ~/.aws/config
$ sudo nano  ~/.aws/config
```

Put below lines in the file ~/.aws/config and save it.

```
[default]
region = ap-southeast-1
output_format = json
```

###### Create mock aws credentials file (method 2):
```
$aws configure

AWS Access Key ID : fakeMyKeyId
AWS Secret Access Key: fakeSecretAccessKey
Default region name: ap-southeast-1
Default output format: json
```

cd to project's main directory. Run :

```
$ sudo sh start.sh
```

This shell file contains required commands for starting docker, executing database & ssm. 
Finally, It runs DynamoDB Admin UI.


#### After executing above instructions, run Middleware Backend Application.

If any maven issues come in, try this & then again run the backend.

```
$ mvn clean package
```

#### To run Frontend:

Check the required versions of NPM & Node then run the following commands:

```
$ npm install
$ npm run serve
```

#### Common troubleshoot issue

For installing the specific version of node:

```
$ sudo n 12.12.0
```

