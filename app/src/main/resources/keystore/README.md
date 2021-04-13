# HTTPS 키 생성

1. `p12` 키 생성

  ```bash
  > keytool -genkey -v -keystore keystore.p12 -alias keystore -keyAlg RSA -storetype pkcs12 -keysize 2048 -validity 10000
  ```

<br/>

2. `pem` 키 생성

  ```bash
  > openssl pkcs12 -in keystore.p12 -out certificates.pem
  > openssl pkcs12 -in keystore.p12 -nodes -nocerts -out key.pem
  ```
