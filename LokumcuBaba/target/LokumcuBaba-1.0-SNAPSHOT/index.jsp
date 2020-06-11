<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">

        <form class="text-center border border-light p-5" action="submitForm">

            <p class="lead font-weight-normal mb-4 mt-2 text-center">LokumcuBaba BAYİLİK ÖN BAŞVURU FORMU</p>


            <input type="text" name="formName" class="form-control mb-4" placeholder="Ad-Soyad" required>

            <%-- pattern, numara girilmediği halde hata vermesini sağlayacak --%>
            <input type="text" pattern="\d*" name="formTCNo" class="form-control mb-4" placeholder="T.C. Kimlik No" maxlength="11" required>

            <div class="form-group">
                <textarea class="form-control rounded-0" name="formAdress" rows="3" placeholder="Adres" required></textarea>
            </div>

            <input type="text" pattern="\d*" name="formPhone" class="form-control mb-4" placeholder="Telefon" maxlength="11" required>

            <input type="email" name="formEmail" class="form-control mb-4" placeholder="E-posta" required>

            <small class="form-text text-muted">
                DOĞUM TARİHİ
            </small>
            <input type="date" name="formBirthdate" max="2002-01-01" pattern="yyyy-mm-dd" class="form-control mb-2" required>

            <p class="h6">Daha önce Perakende Ticareti ile uğraştınız mı?</p>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="formS1" value="Yes">
                <label class="form-check-label">
                    Evet
                </label>
            </div>
            <div class="form-check mb-3">
                <input class="form-check-input" type="radio" name="formS1" value="No" checked>
                <label class="form-check-label">
                    Hayır
                </label>
            </div>
            <div class="form-group">
                <textarea class="form-control rounded-0" name="formS2" rows="3" placeholder="LOKUMCU BABA'yı tercih etmenizin sebebi nedir?"></textarea>
            </div>
            <div class="form-group">
                <textarea class="form-control rounded-0" name="formS3" rows="3" placeholder="İL-İLÇE-SEMT" required></textarea>
            </div>
            <input type="number" name="formS4" class="form-control mb-4" placeholder="Yatırım Miktarı" required>
            <div class="form-group">
                <textarea class="form-control rounded-0" name="formS5" rows="3" placeholder="Eklemek istedikleriniz"></textarea>
            </div>


            <button class="btn btn-info btn-block" type="submit" >Send</button>

        </form>
        <!-- Default form contact -->
    </div>

<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</body>
</html>
