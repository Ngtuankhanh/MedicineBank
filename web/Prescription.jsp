<%-- 
    Document   : Prescription
    Created on : 8 Jul 2024, 02:07:39
    Author     : Kz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Home</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            .btn-outline-info:hover {
                color: whitesmoke;
            }

            .task-description {
                line-height: 1.5;
                /* Adjust line spacing for better readability */
                font-size: 14px;
                color: #333;
                /* Set maximum height for two lines and allow overflow with ellipsis */
                max-height: 3rem;
                /* Adjust height based on font size and line-height */
                overflow: hidden;
                text-overflow: ellipsis;
                /* Transition for smoother expansion with cubic-bezier timing function */
                transition: max-height 0.5s cubic-bezier(0.25, 0.8, 0.25, 1);
            }

            .task-container:hover .task-description {
                max-height: unset;
                /* Remove max-height restriction on hover */
            }
        </style>
    </head>

    <body>

        <jsp:include page="Header.jsp" />

        <div id="wrapper" class="container-fluid">
            <div class="row">
                <!-- Workbook -->
                <div id="workbook" class="col-sm-12 border">
                    <div class="flex-shrink-0 bg-white" style="height: 100%;margin-top: 80px">
                        <a href="#" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom justify-content-center">
                            <span class="fw-semibold" style="font-size: 30px">Quản Lý Đơn Thuốc</span>
                        </a>

                        <div class="row mt-4">
                            <a href="" class="text-decoration-none">
                                <div class="col-sm-12">
                                    <div class="card mb-3 p-3 task-container">
                                        <h4 class="text-dark align-items-center text-center fw-semibold"> Đơn Thuốc 1 </h4>
                                        <p class="task-description">This is a very long description that gets truncated initially.
                                            Hover over me to see the full details. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In
                                            nisi
                                            nibh, suscipit ac velit eget, tincidunt malesuada urna. Donec pretium elementum luctus. Aenean
                                            suscipit
                                            justo vel erat egestas aliquam. Vivamus mi metus, luctus nec aliquet a, aliquet sed nisi. Lorem ipsum
                                            dolor sit amet, consectetur adipiscing elit. Morbi felis nulla, dapibus nec ipsum at, mollis maximus
                                            nunc. Suspendisse commodo neque est, et sollicitudin lectus vestibulum quis. Nullam lorem sem,
                                            consectetur nec arcu tincidunt, ornare ultricies turpis. Curabitur sem tortor, scelerisque in sodales
                                            sed, sagittis eget nibh.</p>
                                    </div>
                                </div>
                            </a>
                            <button>dđ</button>
                        </div>


                    </div>
                </div>

            </div>
        </div>
    </body>
    <jsp:include page="Footer.jsp" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" defer></script>

</html>