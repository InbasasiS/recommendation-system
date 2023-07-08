# Product Recommendation System

### LLD

![Alt text](https://github.com/InbasasiS/recommendation-system/blob/RecommendationSystemDBDesign.jpg?raw=true "Title")

## Requirements

- Build a recommendation system for retail products based on user themes
- When user does not configured themes, Consider recommending using random themes
- example themes, #SummerDelight, #teen, .. 100s of themes
- A user can follow one or more themes
- The product will be associated with a theme
- There can be a maximum of 3 themes & 20 products considered for recommendation
- Everyday, The weightage is calculated for a set of products based on price & recency
- The user themes takes a higher weigtage (2) while the random themes will be lesser weightage(1)
- The products has to be sorted based on the weigtage (sorting will be available while using the DB query, Not implemented in as this is a sample data)

## Quick Start Guide

- This system runs on Java 11 with sample data.
- The sample data is present in the folder src/main/resources/static/products.csv & src/main/resources/static/themes.csv.
- The application will start at port 8080
- Hit the POST api/v1/products API for generating recommendations.

### API Details

### Recommend Products

#### Scenerio 1:

- User Themes - Theme A, Theme B
- Random Themes - Theme D
- All the themes contains enought products to be presented
- The recommendation will be,
- Theme A - 8 products
- Theme B - 8 products
- Theme D - 4 products


POST - http://localhost:8080/api/v1/products?user=100&count=20

Body:

```json
{
    "themes": [
        1001,
        2001
    ]
}```

Response:

```json
[
    {
        "id": 101,
        "name": "Product_A_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 102,
        "name": "Product_B_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 103,
        "name": "Product_C_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 104,
        "name": "Product_D_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 105,
        "name": "Product_E_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 106,
        "name": "Product_F_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 107,
        "name": "Product_G_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 108,
        "name": "Product_H_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 201,
        "name": "Product_A_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 202,
        "name": "Product_B_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 203,
        "name": "Product_C_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 204,
        "name": "Product_D_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 205,
        "name": "Product_E_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 206,
        "name": "Product_F_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 207,
        "name": "Product_G_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 208,
        "name": "Product_H_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 401,
        "name": "Product_A_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 402,
        "name": "Product_B_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 403,
        "name": "Product_C_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 404,
        "name": "Product_D_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    }
]```

#### Scenerio 2:

- User Themes - Theme A, Theme B
- Random Themes - Theme D
- The totalproducts in the themes.csv is adjusted to 5 for Theme B
- Now, The User Theme B has only 5 data
- The recommendation will be,
- Theme A - 11 products
- Theme B - 5 products
- Theme D - 4 products

POST - http://localhost:8080/api/v1/products?user=100&count=20

Body:

```json
{
    "themes": [
        1001,
        2001
    ]
}```

Response:

```json
[
    {
        "id": 101,
        "name": "Product_A_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 102,
        "name": "Product_B_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 103,
        "name": "Product_C_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 104,
        "name": "Product_D_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 105,
        "name": "Product_E_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 106,
        "name": "Product_F_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 107,
        "name": "Product_G_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 108,
        "name": "Product_H_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 109,
        "name": "Product_I_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 110,
        "name": "Product_J_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 111,
        "name": "Product_K_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 10
        },
        "weigtage": 0.5
    },
    {
        "id": 201,
        "name": "Product_A_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 202,
        "name": "Product_B_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 203,
        "name": "Product_C_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 204,
        "name": "Product_D_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 205,
        "name": "Product_E_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 401,
        "name": "Product_A_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 402,
        "name": "Product_B_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 403,
        "name": "Product_C_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 404,
        "name": "Product_D_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    }
]
```

#### Scenerio 3:

- User Themes - Theme A, Theme B
- Random Themes - Theme D
- The totalproducts in the themes.csv is adjusted to 5 for Theme A
- The totalproducts in the themes.csv is adjusted to 5 for Theme B
- Now, The User Theme A & Theme B has only 5 products
- The recommendation will be,
- Theme A - 5 products
- Theme B - 5 products
- Theme D - 10 products

POST - http://localhost:8080/api/v1/products?user=100&count=20

Body:

```json
{
    "themes": [
        1001,
        2001
    ]
}```

Response:

```json
[
    {
        "id": 101,
        "name": "Product_A_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 102,
        "name": "Product_B_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 103,
        "name": "Product_C_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 104,
        "name": "Product_D_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 105,
        "name": "Product_E_Theme_A",
        "price": 300.0,
        "theme": {
            "id": 1001,
            "name": "Theme_A",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 201,
        "name": "Product_A_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 202,
        "name": "Product_B_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 203,
        "name": "Product_C_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 204,
        "name": "Product_D_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 205,
        "name": "Product_E_Theme_B",
        "price": 300.0,
        "theme": {
            "id": 2001,
            "name": "Theme_B",
            "totalProducts": 5
        },
        "weigtage": 0.5
    },
    {
        "id": 401,
        "name": "Product_A_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 402,
        "name": "Product_B_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 403,
        "name": "Product_C_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 404,
        "name": "Product_D_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 405,
        "name": "Product_E_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 406,
        "name": "Product_F_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 407,
        "name": "Product_G_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 408,
        "name": "Product_H_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 409,
        "name": "Product_I_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    },
    {
        "id": 410,
        "name": "Product_J_Theme_D",
        "price": 300.0,
        "theme": {
            "id": 4001,
            "name": "Theme_D",
            "totalProducts": 20
        },
        "weigtage": 0.5
    }
]
```
