#!/bin/bash

NAME=${1?Error: no name given}
KS=${2:-Keystore}
TS=${3:-truststore}

keytool -importcert -file ca.crt -alias $NAME -keystore $TS -storepass password
keytool -genkeypair -alias $NAME -keyalg RSA -keysize 2048 -keystore $KS -validity 365 -storepass password
keytool -certreq -alias $NAME -keystore $KS -file $NAME.csr -storepass password
openssl x509 -req $NAME.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out $NAME.crt -days 365 -sha256
keytool -importcert -trustcacerts -keystore $KS -storepass password -file ca.crt
keytool importcert -trustcacerts -keystore $KS -storepass password -file $NAME.crt -alias $NAME
