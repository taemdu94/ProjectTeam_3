<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/footers/">   

    <!-- Bootstrap core CSS -->
    <link href="./css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="headers.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="footers.css" rel="stylesheet">    

    <link href="reset.css" rel="stylesheet">
</head>
<body>
 <div class="container themed-container" style="background-color: #4598d3;">
        <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
                <img src="icon_y_l.png"  class="img" alt="..." height="40" width="40">&nbsp;        
                <span class="fs-4">예사날</span>
            </a>    

            <ul class="nav nav-pills">
                <button type="button" onclick="location.href='./내정보_예약내역'" class="btn btn-secondary">예약내역</button>&nbsp;
                <button type="button" onclick="location.href='./사업자_사업자회원정보'" class="btn btn-secondary">사업자</button>&nbsp;
                <button type="button" onclick="location.href='./login.html'" class="btn btn-secondary">로그인</button>&nbsp;           
                <button type="button" onclick="location.href='./memchoice.html'" class="btn btn-secondary">회원가입</button>             
            </ul>
        </header>
    </div>

    <main>
        <div class="container col-lg-5">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">일반회원</button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">사업자회원</button>
                </li>               
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="container tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <form action="./index.html 일반로그인" method="get">
                        <div class="p-2"></div>
                        <div class="row align-items-center">
                            <div class="col-sm-8">
                                    <label for="exampleInputEmail1" class="form-label">Id</label>
                                    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">	
                                    <label for="exampleInputPassword1" class="form-label">Password</label>
                                    <input type="password" class="form-control" id="exampleInputPassword1">
                            </div>
                            <div class="col">
                                <button type="submit" class="btn btn-secondary" id="btnmargin">로그인</button>
                            </div>
                        </div>     
                    </form>
                </div>
                <div class="container tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                    <form action="./index.html 사업자로그인" method="get">
                        <div class="p-2"></div>
                        <div class="row align-items-center">
                            <div class="col-sm-8">
                                <label for="exampleInputEmail1" class="form-label">Id</label>
                                <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">	
                                <label for="exampleInputPassword1" class="form-label">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1">
                            </div>
                            <div class="col">
                                <button type="submit" class="btn btn-secondary" id="btnmargin">로그인</button>
                            </div>
                        </div>     
                    </form>
                </div>
            </div>
            <div class="p-2"></div>
            <div class="findidpwd">
                <a href="./findid.html">아이디</a>/<a href="./findpwd.html">패스워드</a>찾기
            </div>
        </div>
        
    </main>
    <div class="p-3"></div>
    <div class="container themed-container" style="background-color: #dfe3e6;">
        <footer class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
<!--         <footer class="py-3 my-4"> -->
            <ul class="nav nav-pills">
                <button type="button" class="btn btn-secondary">고객센터</button>&nbsp;           
                <button type="button" class="btn btn-secondary">회사소개</button>&nbsp;           
            </ul>
        </footer>
    </div> 

    <script src="./js/bootstrap.bundle.min.js"></script>     
</body>
</html>