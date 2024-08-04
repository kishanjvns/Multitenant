# How to launch this Application
    ```sh
    To run this code you should run the main method of the TestInstrumentServiceApplication class present inside the
    test src directory, as I am utilizing the TestContainer to launch the postgres so that
    I can use this TestContainer for development purpose as well, the main method of TestInstrumentServiceApplication 
    will trigger the main method MultitenantApplication file
   ``
# Multitenant
Testing Hibernate 6.2 multi tenant support and spring boot 3.2 feature
# Data Isolation
# created DataIsolation branch for that
So wht is this data isolation means in multi tenant 
well if we support more than 1 customer in our single application then we do not want
that the other customer data is visible to another customer and to achieve that
we have several strategies
# 1- Partitioned Data
    Tenant as a separate coumn in each table
# 2- Separate Schema
    Sehema per tenant means for each tenant there will be separate schema
# 3- Database per tenant
    Database per tenant menas separate databae for each tenant

# Tradeoffs 
    All above mentioned strategies have their own tradeoffs that we can choose
    as per our businesss needs
but in this dataIsolation branch I have implemented 'Separate Schema' strategies

## Making a POST Request

To make a POST request to the `localhost:8080/instrument` endpoint, use the following `curl` command:

```sh
POST Request to create instrument for duke as tenant

curl --location 'localhost:8080/instrument' \
--header 'X-TenantId: dukes' \
--header 'Content-Type: application/json' \
--data '{
    "name":"steinaway",
    "type":"piano"
}'
```
At the momment the schema is supporting for two tenants dukes and jack other than that will be land to PUBLIC schema in postgres
```sh
   GET Request to fetch the instrument
    curl -H "X-TenantId:dukes" http://localhost:8080/instrument
```

