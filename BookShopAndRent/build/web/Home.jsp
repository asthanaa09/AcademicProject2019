<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.BufferedInputStream" %>
<%@page import="java.io.BufferedOutputStream" %>
<%@page import="java.io.FileInputStream" %>
<%@page import="javax.servlet.ServletOutputStream" %>




    <script type="text/javascript">
        jssor_1_slider_init = function () {

            var jssor_1_SlideoTransitions = [
                [{b: 0, d: 600, y: -290, e: {y: 27}}],
                [{b: 0, d: 1000, y: 185}, {b: 1000, d: 500, o: -1}, {b: 1500, d: 500, o: 1}, {b: 2000, d: 1500, r: 360}, {b: 3500, d: 1000, rX: 30}, {b: 4500, d: 500, rX: -30}, {b: 5000, d: 1000, rY: 30}, {b: 6000, d: 500, rY: -30}, {b: 6500, d: 500, sX: 1}, {b: 7000, d: 500, sX: -1}, {b: 7500, d: 500, sY: 1}, {b: 8000, d: 500, sY: -1}, {b: 8500, d: 500, kX: 30}, {b: 9000, d: 500, kX: -30}, {b: 9500, d: 500, kY: 30}, {b: 10000, d: 500, kY: -30}, {b: 10500, d: 500, c: {x: 125.00, t: -125.00}}, {b: 11000, d: 500, c: {x: -125.00, t: 125.00}}],
                [{b: 0, d: 600, x: 535, e: {x: 27}}],
                [{b: -1, d: 1, o: -1}, {b: 0, d: 600, o: 1, e: {o: 5}}],
                [{b: -1, d: 1, c: {x: 250.0, t: -250.0}}, {b: 0, d: 800, c: {x: -250.0, t: 250.0}, e: {c: {x: 7, t: 7}}}],
                [{b: -1, d: 1, o: -1}, {b: 0, d: 600, x: -570, o: 1, e: {x: 6}}],
                [{b: -1, d: 1, o: -1, r: -180}, {b: 0, d: 800, o: 1, r: 180, e: {r: 7}}],
                [{b: 0, d: 1000, y: 80, e: {y: 24}}, {b: 1000, d: 1100, x: 570, y: 170, o: -1, r: 30, sX: 9, sY: 9, e: {x: 2, y: 6, r: 1, sX: 5, sY: 5}}],
                [{b: 2000, d: 600, rY: 30}],
                [{b: 0, d: 500, x: -105}, {b: 500, d: 500, x: 230}, {b: 1000, d: 500, y: -120}, {b: 1500, d: 500, x: -70, y: 120}, {b: 2600, d: 500, y: -80}, {b: 3100, d: 900, y: 160, e: {y: 24}}],
                [{b: 0, d: 1000, o: -0.4, rX: 2, rY: 1}, {b: 1000, d: 1000, rY: 1}, {b: 2000, d: 1000, rX: -1}, {b: 3000, d: 1000, rY: -1}, {b: 4000, d: 1000, o: 0.4, rX: -1, rY: -1}]
            ];

            var jssor_1_options = {
                $AutoPlay: 1,
                $Idle: 2000,
                $CaptionSliderOptions: {
                    $Class: $JssorCaptionSlideo$,
                    $Transitions: jssor_1_SlideoTransitions,
                    $Breaks: [
                        [{d: 2000, b: 1000}]
                    ]
                },
                $ArrowNavigatorOptions: {
                    $Class: $JssorArrowNavigator$
                },
                $BulletNavigatorOptions: {
                    $Class: $JssorBulletNavigator$
                }
            };

            var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

            /*#region responsive code begin*/

            var MAX_WIDTH = 980;

            function ScaleSlider() {
                var containerElement = jssor_1_slider.$Elmt.parentNode;
                var containerWidth = containerElement.clientWidth;

                if (containerWidth) {

                    var expectedWidth = Math.min(MAX_WIDTH || containerWidth, containerWidth);

                    jssor_1_slider.$ScaleWidth(expectedWidth);
                } else {
                    window.setTimeout(ScaleSlider, 30);
                }
            }

            ScaleSlider();

            $Jssor$.$AddEvent(window, "load", ScaleSlider);
            $Jssor$.$AddEvent(window, "resize", ScaleSlider);
            $Jssor$.$AddEvent(window, "orientationchange", ScaleSlider);
            /*#endregion responsive code end*/
        };
    </script>
    <div id="singlePage"> <div class="container-fluid bg-dark">
            <div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:980px;height:380px;overflow:hidden;visibility:hidden;">
                <!-- Loading Screen -->
                <div data-u="loading" class="jssorl-009-spin" style="position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;background-color:rgba(0,0,0,0.7);">
                    <img src="img/b1.jpeg" style="margin-top:-19px;position:relative;top:50%;width:38px;height:38px;"  />
                </div>
                <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
                    <div>
                        <img data-u="image" src="img/Libraries.jpeg" />
                        <div data-t="0" style="position:absolute;top:320px;left:30px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);">Anurag Asthana</div>
                    </div>
                    <div>
                        <img data-u="image" src="img/Libraries.jpeg" />
                        <div data-ts="flat" data-p="1360" style="position:absolute;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
                            <!--<div data-t="1" style="position:absolute;top:-50px;left:125px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);"></div>-->
                        </div>
                    </div>
                    <div>
                        <img data-u="image" src="img/qw.jpg" />
                        <div data-ts="flat" data-p="1360" style="position:absolute;top:0px;left:0px;width:980px;height:380px;">
                            <div data-t="2" style="position:absolute;top:30px;left:-505px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);">Finger catchable right to left</div>
                        </div>
                    </div>
                    <div>
                        <img data-u="image" src="img/qq.jpg" />
                        <div data-t="3" style="position:absolute;top:30px;left:30px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);">responsive, scale smoothly</div>
                    </div>
                    <div>
                        <img data-u="image" src="img/pexels-photo-1122865.jpeg" />
                        <div data-t="4" style="position:absolute;top:30px;left:30px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);">image, text, and custom layers</div>
                    </div>
                    <div>
                        <img data-u="image" src="img/aj.jpg" />
                        <div data-t="5" style="position:absolute;top:30px;left:600px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);">tons of transition type</div>
                    </div>
                    <div>
                        <img data-u="image" src="img/pexels-photo-1122865.jpeg" />
                        <div data-t="6" style="position:absolute;top:30px;left:30px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);">visual slider maker</div>
                    </div>
                    <div data-b="0">
                        <img data-u="image" src="img/lib.jpeg" />
                        <div data-t="7" style="position:absolute;top:-50px;left:30px;width:500px;height:40px;font-family:Oswald,sans-serif;font-size:32px;font-weight:200;line-height:1.2;text-align:center;background-color:rgba(255,188,5,0.8);">play in and play out</div>
                    </div>
                    <div>
                        <img data-u="image" src="img/lrli.jpeg" />
                        <div data-ts="flat" data-p="1360" style="position:absolute;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
                            <div data-t="8" data-ts="preserve-3d" style="position:absolute;top:25px;left:150px;width:250px;height:250px;overflow:hidden;background-color:rgba(40,177,255,0.6);">
                                <div data-t="9" style="position:absolute;top:100px;left:25px;width:200px;height:50px;font-family:Oswald,sans-serif;font-size:24px;font-weight:200;line-height:2.08;">A Child Layer</div>
                            </div>
                        </div>
                    </div>
                    <div>
                        <img data-u="image" src="img/hv.jpg" />
                        <div data-ts="flat" data-p="1360" style="position:absolute;top:0px;left:0px;width:980px;height:380px;overflow:hidden;">
                            <div data-t="10" style="position:absolute;top:25px;left:100px;width:300px;height:260px;font-family:Oswald,sans-serif;font-size:24px;font-weight:200;line-height:1.25;padding:15px 15px 15px 15px;box-sizing:border-box;background-color:rgba(40,177,255,0.6);background-clip:padding-box;">This is full customized content layer.<br />​<br />

                                Everything is allowed.<br />​<br />You can insert

                                <a href="http://wwww.jssor.com">
                                    a link
                                </a> or an image

                                <img src="img/icon_chrome.png" /> here.
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Bullet Navigator -->
                <div data-u="navigator" class="jssorb052" style="position:absolute;bottom:12px;right:12px;" data-autocenter="1" data-scale="0.5" data-scale-bottom="0.75">
                    <div data-u="prototype" class="i" style="width:16px;height:16px;">
                        <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                        <circle class="b" cx="8000" cy="8000" r="5800"></circle>
                        </svg>
                    </div>
                </div>
                <!-- Arrow Navigator -->
                <div data-u="arrowleft" class="jssora053" style="width:55px;height:55px;top:0px;left:25px;" data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <polyline class="a" points="11040,1920 4960,8000 11040,14080 "></polyline>
                    </svg>
                </div>
                <div data-u="arrowright" class="jssora053" style="width:55px;height:55px;top:0px;right:25px;" data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
                    <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <polyline class="a" points="4960,1920 11040,8000 4960,14080 "></polyline>
                    </svg>
                </div>
            </div></div></div>
    <script type="text/javascript">jssor_1_slider_init();</script>
    <!-- #endregion Jssor Slider End -->

    <!--image slider HTML AND JS ended here -->
    <!--filter result-->
    <!--log in form-->

</br>
  
    <!--shop cards-->
    <%

       String filePath = filePath = getServletContext().getInitParameter("file-upload-location");
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:oracle1", "anurag", "asthana");
            Statement st = con.createStatement();
            rs = st.executeQuery("select * from Book_stock");

        } catch (Exception excep) {

            excep.printStackTrace();
            System.out.println("yes exception anurag");

        }


    %>
    <div class="container-fluid">
        <div class="row" >
            <div class="col-md-3" >
                <!--creating bookcategory section and filter section-->

                <div class="row boxShadow ">
                    <div class="col-md-10"><div class="hamburgerBtn" onclick="openButton(this)">
                            <div class="bar1"></div>
                            <div class="bar2"></div>
                            <div class="bar3"></div>
                            <p class="glow">Category</p>
                        </div></div>
                    <div class="col-md-2">filter</div>

                </div>





            </div>




            <div class="col-md-9"> 





                <div class="row">
                    <% while (rs.next()) {%>

                    <div class="col-md-4 ">
                        <!--<h1> <a href="Test?isbn=</*%=rs.getString("isbn")%*/>&action=ordernow"></a>Get</h1>-->
                        <div class="card bg-gradient-warning shadow" style="width: 17rem;">
                            <%String imgPath = filePath + rs.getString("book_image");
                                session.setAttribute("imgPath", imgPath);%>
                            <center><img class="zoom" src= "images/<%=rs.getString("book_image")%>" alt="Card image cap"  style="width:185px;height:270px;padding-top: 40px"></center>
                            <div class="card-body">
                                <a href="Test?isbn=<%=rs.getString("isbn")%>&action=ordernow"> <p class="card-title limitContentInTags" length="50"><%=rs.getString("book_title")%></p></a>
                                <p class="card-text"><b><span><img src="img/Indian_Rupee_symbol_185519.png" style="height:15px;"></span><strong><%=rs.getString("price")%></strong></b></p>
                                <center> <button type="button" class="btn bt btn-danger"><span><img src="img/crt.png"> Add</span></Button> <a ui-sref="BuyBook" ui-sref-active="active" class="btn bt btn-primary"><span><img src="img/btn.png"> Buy </span></a>
                                    <!--  this is written inside the anchor tag of buy button above inside href=   "TestBuyBook.html?isbn=<%//=rs.getString("isbn")%>&action=ordernow"--> 
                                </center>
                            </div>
                        </div></br>

                    </div>

                    <%}%>
                </div> 
            </div>

            </center></div></div>


    <!--shopping card ended here-->
    <!---- //registration form----->
  
    <!--footer design area-->



 