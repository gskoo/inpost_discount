In order to run application execute commands:
```
docker build --tag java-docker .
docker run --publish 8080:8080 java-docker
```

Parameters required to calculate discount:
```
uuid
amount
discountType - available options:AMOUNT, PERCENTAGE
```
Sample usage:
```
localhost:8080/discount?uuid=19a53f75-56d0-4e9a-85a6-18a378dc7400&amount=10&discountType=AMOUNT
localhost:8080/discount?uuid=19a53f75-56d0-4e9a-85a6-18a378dc7400&amount=10&discountType=PERCENTAGE
```
