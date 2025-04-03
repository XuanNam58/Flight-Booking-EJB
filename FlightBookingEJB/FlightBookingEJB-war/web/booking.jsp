<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Đặt Vé Máy Bay</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .seat-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            border: 2px solid #ccc;
            padding: 20px;
            border-radius: 10px;
            background-color: #f8f9fa;
        }
        .seat {
            width: 60px;
            height: 60px;
            margin: 10px;
            background-color: #28a745;
            color: white;
            text-align: center;
            line-height: 60px;
            cursor: pointer;
            border-radius: 8px;
            font-weight: bold;
            transition: background 0.3s ease;
        }
        .seat:hover, .seat.selected {
            background-color: #dc3545;
        }
        .modal-content {
            border-radius: 10px;
            padding: 20px;
        }
        .modal-header {
            background-color: #007bff;
            color: white;
            border-radius: 10px 10px 0 0;
            padding: 15px;
        }
        .modal-body {
            background-color: #f8f9fa;
        }
        .form-label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center">Đặt Vé Máy Bay</h2>
        <div class="row justify-content-center">
            <div class="col-md-6 text-center">
                <div class="seat-container">
                    <% for (int i = 1; i <= 10; i++) { %>
                        <div class="seat" onclick="selectSeat(<%= i %>)">S<%= i %></div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal đặt vé -->
    <div class="modal fade" id="bookingModal" tabindex="-1" aria-labelledby="bookingModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="bookingModalLabel">Thông Tin Hành Khách</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form>
                        <div class="mb-3">
                            <label class="form-label">Tên Hành Khách</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số Điện Thoại</label>
                            <input type="text" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số CCCD</label>
                            <input type="text" class="form-control" required placeholder="Nhập số CCCD">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Mã TAX</label>
                            <input type="text" class="form-control" required placeholder="Nhập mã TAX">
                        </div>
                        <input type="hidden" id="seat-number" name="seat">
                        <button type="submit" class="btn btn-primary w-100">Xác Nhận Đặt Vé</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        function selectSeat(seatNumber) {
            document.getElementById('seat-number').value = seatNumber;
            document.getElementById('bookingModalLabel').innerText = "Đặt vé cho ghế S" + seatNumber;
            var bookingModal = new bootstrap.Modal(document.getElementById('bookingModal'));
            bookingModal.show();
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
