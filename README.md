# ๐ ํฌ์ผ๋ชฌ ๋ ๋ถ๋ ๋ถ

ํฌ์ผ๋ชฌ๋นต์ ์ฌ ๋จน์ง ๋ชปํ ์ฌ๋๋ค์ ํ์ ํ์ด์ฃผ๊ธฐ ์ํ ์ฌ์ดํธ

์ ์ ๊ธฐ๊ฐ : 2022.06.19 ~ 2022.06.16 (7์ผ)

# :information_desk_person: ํ์ ์๊ฐ

๐ฆ : **BACK-END (3๋ช)**

 + ๊น๋ฏผ์ฃผ : ๋ก๊ทธ์ธ, ํ์๊ฐ์, ์ธ์ฆ(JWT) ๊ตฌํ

 + ๊น์น์ฐฌ : ๋ฐ์ดํฐ๋ฒ ์ด์ค ํฌ๋กค๋ง, ๊ฒ์ CRUD, ๋ฉ์ธ ํ์ด์ง, ๋ํ์ผ ํ์ด์ง ๊ตฌํ

 + ์ฌ๊ทํ : ๋๊ธ CRUD, ์ข์์ ๊ธฐ๋ฅ ๊ตฌํ

๐ : **FRONT-END (1๋ช)** <a href="https://github.com/jjugwen/pokemon_front">front-end github</a>

 + ์ด์์ฃผ

# :dizzy: ํต์ฌ๊ธฐ๋ฅ
> 1) ํ์๊ฐ์ / ๋ก๊ทธ์ธ
 + JWT ์ธ์ฆ ๋ฐฉ์์ผ๋ก ๋ก๊ทธ์ธ ๊ตฌํ
 + ID ์ค๋ณตํ์ธ, ๊ฐ ํ๋๋ณ ์ ํจ์ฑ์ฒดํฌ

> 2) ํฌ์ผ๋ชฌ ์ด๋
 + ํฌ์ผ๋ชฌ ๋ชฉ๋ก
 + ํฌ์ผ๋ชฌ ์์ธ ์กฐํ
 + ํฌ์ผ๋ชฌ ์ข์์

> 3) ๋๊ธ CRUD
 +๋๊ธ ๋ฑ๋ก, ๋๊ธ ์์ , ๋๊ธ ์ญ์ 

# :tv: ๋ฐ๋ชจ์์
<img src="https://img.shields.io/badge/YouTube-FF0000?style=flat&logo=YouTube&logoColor=white"/> https://youtu.be/JPpEf-CZooE

# :computer: ๊ธฐ์  ์คํ 
#### Server 
  <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">
  
#### Framework
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"><img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white">
  
#### Language
  <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
  
#### Database
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  
#### Tool
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"><img src="https://img.shields.io/badge/Git-00000?style=for-the-badge&logo=Git&logoColor=F05032]"/><img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white]"/>

# :key: ํธ๋ฌ๋ธ ์ํ
> 1) ๋ฐฑ์๋ - ๋ก๊ทธ์ธ, ํ์๊ฐ์
 + ์ํ๋ฆฌํฐ - ํ๋ก ํธ์ ์ฐ๊ฒฐํ๊ธฐ ์ํด ํผ ๋ก๊ทธ์ธ์ ๋นํ์ฑํ => ํํฐ๋ฅผ ๋ฌ์์ฃผ์ด result ๊ฐ์ ์ ๋ฌ
 + ์ํ๋ฆฌํฐ๋ฅผ ์ฌ์ฉํ์ฌ ๋ฆฌ์กํธ ์๋ฒ์ ์ฐ๋ ์ํค๋ ๊ฒ ์ด๋ ค์ => ๋ฐฉ๋ฒ์ ์์๋ณด๋ค rest api๋ฅผ ์ฌ์ฉํ๋ฉด์ ์ธ์์ ๊ฐ์ด ์ฌ์ฉํ๋ ๊ฒ์ด ์๋ง์ง ์๋ค๊ณ  ํ๋จ๋์ด JWT ํ ํฐ์ผ๋ก ๋ก๊ทธ์ธ ๋ฐฉ์ ๋ณ๊ฒฝ
 + ๋ก๊ทธ์ธ, ํ์๊ฐ์ ํ๋ฉด์์๋ JWTํ ํฐ์ด ํ์ํ์ง ์์ => tokenfilter๋ฅผ ํตํด "/commet" ์ "/like" ์ฐฝ๊ตฌ์์๋ง token ์ฌ๋ถ๋ฅผ ํ์ธํ๋๋ก ์ค์ 
 + ๊ธฐ์กด JWT ๊ตฌํ ์ ๋ง๋ฃ๊ธฐํ ์์ด ์ก์ธ์ค ํ ํฐ๋ง ๊ตฌํ => ๋ณด์์ ์ํด ๋ง๋ฃ๊ธฐ๊ฐ์ ์ ํ ๋ค ๋ค์ ํ ํฐ์ ์ฌ๋ฐ๊ธ ๋ฐ์ ์ ์๊ฒ ๋ฆฌํ๋ ์ ํ ํฐ์ ์์ฑ

> 2) ๋ฐฑ์๋ - ๊ฒ์
 + ๊ฒ์๊ธฐ๋ฅ ์ฌ์ฉํ ๋ ๊ฒ์๊ฒฐ๊ณผ ์กฐํ์ JSON Parse ์๋ฌ๊ฐ ๋จ๋๋ถ๋ถ 
 + @ALLArgsConstructor ๋ฅผ ์ฌ์ฉํ์๋ ์๋ฌ๊ฐ ๋ ์ ์ด๋ธํ์ด์ ๊ธฐ๋ฅํ์ตํ
 + SearchDto ํด๋์ค์ @NoArgsConstructor ๋ฅผ ์ฌ์ฉํ์ฌ ํด๊ฒฐํ์๋ค
 + ์์ฑ์๋ฅผ ์๋์์ฑํ๋ ์ด๋ธํ์ด์์ด๋ค
 + ํ๋ผ๋ฏธํฐ๊ฐ ์๋ ์์ฑ์๋ฅผ ๋ง๋ค์ด์ค๋ค

> 3) ๋ฐฑ์๋ - ์๋ฒ ๋ฐฐํฌ
 + ๋ฐฑ ์๋ฒ ๋ฐฐํฌํ ํ๋ก ํธ ๋ก์ปฌํ๊ฒฝ์์ ์์ ์ ๊ทผ์ ์ค๋ฅ ๋ฐ์
 + -Access to XMLHttpRequest at 'http://13.124.220.124/' from origin 'http://localhost:3000' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
 + ์๋ตํค๋์ "Access-Control-Allow-Origin"์ ๋ด์ฉ์ด ์์ด์ CORS ์ ์ฑ์ ๋งํ์๋๋ฐ, Java Servlet์ Filter ๊ตฌํ์ฒด๋ฅผ ํตํด response.setHeader("Access-Control-Allow-Origin", "url")์ ํ์ฉํด์ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ์๋ค.
