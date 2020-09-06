# Promo-Pngine
     <b> request need to pass in body</b><br/>
      database name  : promotion<br/>
      table will be contains id, name and price<br/>
      application.properties: <br>
      # Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
      spring.datasource.url = jdbc:mysql://localhost:3306/promotion?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false

      spring.datasource.username = "Your Mysql username"<br/>
      spring.datasource.password = "Your MySql password"
      <br/>
      -Remove comments for first time run<br/>
      #spring.jpa.hibernate.ddl-auto = create
  <br/>
<b>Fetching Record  in various Senerio:</b><br/>
     API EndPoint : http://localhost:8080/product/
     <br/>
    <b>1:- Scenario A </b><br/>
    Input  : <br/>
     [{
        "name":"A",
        "noOfproduct":1
    },{
        "name":"B",
        "noOfproduct":1
    },
    {
        "name":"C",
        "noOfproduct":1
    }]
    <br/>
     Output : <br/>
    {
        "productDto": [
            {
                "name": "A",
                "noOfproduct": 1,
                "price": 50.0
            },
            {
                "name": "B",
                "noOfproduct": 1,
                "price": 30.0
            },
            {
                "name": "C",
                "noOfproduct": 1,
                "price": 20.0
            }
        ],
        "totalAmount": 100.0
    }
 <br/>
<b>2:- cenario B </b><br/>
    a-> offer : how much offer you want to give for a particular product<br/>
       -minBuyproductCountForOffer: buying how many unit you want to give offer<br/>
       for example : if someone buy 3 product then 10 % off <br/>
    b->: if product is new then no offer so in this case no discount</br>
    Input  : <br/>
   [{
       "name":"A",
       "noOfproduct":5,
       "offer":13.33,
       "minBuyproductCountForOffer":3
   },{
       "name":"B",
       "noOfproduct":5,
       "offer":25,
       "minBuyproductCountForOffer":2
   },
   {
       "name":"C",
       "noOfproduct":1
   }]
<br/>
<b>3:-Scenario C </b><br/>
  Input  : <br/>
  [{
      "name":"A",
      "noOfproduct":3,
      "offer":13.9,
      "minBuyproductCountForOffer":3
  },{
      "name":"B",
      "noOfproduct":5,
      "offer":25,
      "minBuyproductCountForOffer":2
  },
  {
      "name":"C",
      "noOfproduct":0
  },
  {
      "name":"D",
      "noOfproduct":2
  }]
  <br/>
