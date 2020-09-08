# Promo-Engine
      Request need to pass in body
      database name  : promotion
      table will be contains id, name and price
      application.properties:
      # Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
      spring.datasource.url = jdbc:mysql://localhost:3306/promotion?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false

      spring.datasource.username = "Your Mysql username"
      spring.datasource.password = "Your MySql password"
   
      -Remove comments for first time run<br/>
      #spring.jpa.hibernate.ddl-auto = create
      
      Insert :
      PostMapping : create the table and insert the data in db
      API EndPoint : http://localhost:8080/product/
      input :
      [{
        "name":"A",
        "price":50
      },
      {
         "name":"B",
        "price":30
      },
      {
         "name":"C",
         "price":20
      },
            {
         "name":"D",
        "price":15
      }
      ]

      Fetching Record  in various Senerio:
       API EndPoint : http://localhost:8080/product/
       
       1:- Scenario A
         Input :
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
 
     Output : 
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
      2:- cenario B
      a-> offer : how much offer you want to give for a particular product .offer=13.33 means 13.3% discount
            minBuyproductCountForOffer: buying how many unit you want to give offer
            for example : if someone buy 3 product then 10 % off
      b->: if product is new then no offer so in this case no discount
      
      Input  : 
      
       [{
       "name":"A",
       "noOfproduct":5,
       "offer":13.33,
       "minBuyproductCountForOffer":3
        },
        {
       "name":"B",
       "noOfproduct":5,
       "offer":25,
       "minBuyproductCountForOffer":2
       },
       {
       "name":"C",
       "noOfproduct":1
       }]
       
    3-Scenario C :
       Input  :
       
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
