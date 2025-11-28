# LiberVN - Ứng dụng Đọc Sách

Một ứng dụng đọc sách cá nhân hóa và tiện lợi cho Android, cho phép người dùng quản lý thư viện sách cá nhân, đọc sách PDF và theo dõi tiến độ đọc.

## 📱 Giới thiệu

LiberVN là ứng dụng đọc sách Android được xây dựng bằng Java, cung cấp trải nghiệm đọc sách tối ưu với các tính năng quản lý thư viện cá nhân, theo dõi tiến độ đọc và quản lý sách yêu thích.

## ✨ Tính năng

### 🔐 Xác thực người dùng
- Đăng ký tài khoản mới
- Đăng nhập/Đăng xuất
- Quản lý phiên đăng nhập (Session Management)
- Tài khoản admin mặc định: `admin/admin`

### 📚 Quản lý sách
- Thêm sách mới với thông tin chi tiết (tiêu đề, tác giả, thể loại, tóm tắt)
- Chỉnh sửa thông tin sách
- Xóa sách
- Xem danh sách sách
- Tìm kiếm sách nhanh chóng
- Xem chi tiết sách

### 📖 Quản lý chương
- Thêm và quản lý các chương của sách
- Định nghĩa trang bắt đầu và kết thúc cho mỗi chương
- Điều hướng nhanh giữa các chương

### 📄 Đọc sách
- Đọc sách PDF với trình xem PDF tích hợp
- Điều hướng theo chương
- Theo dõi tiến độ đọc tự động
- Lưu trang đang đọc để tiếp tục sau

### ⭐ Sách yêu thích
- Thêm/Xóa sách khỏi danh sách yêu thích
- Xem danh sách sách yêu thích

### 📊 Theo dõi tiến độ
- Tự động lưu trang đang đọc
- Tiếp tục đọc từ trang đã lưu
- Quản lý tiến độ đọc cho nhiều sách

## 🛠️ Công nghệ sử dụng

- **Ngôn ngữ**: Java
- **Platform**: Android
- **Database**: SQLite
- **UI Framework**: Android Material Design
- **PDF Viewer**: [Pdf-Viewer](https://github.com/afreakyelf/Pdf-Viewer) (v2.3.6)
- **Image Loading**: Glide (v4.16.0)

### Dependencies chính
- AndroidX AppCompat
- Material Design Components
- Navigation Component
- ConstraintLayout

## 📋 Yêu cầu hệ thống

- **Android SDK**: Minimum SDK 24 (Android 7.0 Nougat)
- **Target SDK**: 35
- **Java Version**: 11
- **Gradle**: 8.8.2

## 📸 Screenshots
<img width="426" height="798" alt="Screenshot 2025-11-29 011508" src="https://github.com/user-attachments/assets/bde6f2d3-bf26-41f1-b500-cd302d244249" />
<img width="427" height="772" alt="Screenshot 2025-11-29 011534" src="https://github.com/user-attachments/assets/deb3b189-1da7-4d9d-8943-c59df8d5fc4f" />
<img width="407" height="892" alt="Screenshot 2025-11-29 012351" src="https://github.com/user-attachments/assets/2da26c80-4617-4109-bf25-51a6a9c9dfd0" />
<img width="407" height="892" alt="Screenshot 2025-11-29 012406" src="https://github.com/user-attachments/assets/c0601f73-d81a-48b6-9d18-9b6bd3592d11" />
<img width="408" height="893" alt="Screenshot 2025-11-29 012433" src="https://github.com/user-attachments/assets/dcd1c143-ac15-44c7-ad08-abb8fd95b181" />
<img width="406" height="890" alt="Screenshot 2025-11-29 012515" src="https://github.com/user-attachments/assets/fd738022-5242-42b9-86d7-e3d85bb15282" />
<img width="406" height="892" alt="Screenshot 2025-11-29 012445" src="https://github.com/user-attachments/assets/96d6d174-8003-45c0-b875-61a8551acd67" />
<img width="428" height="843" alt="Screenshot 2025-11-29 012928" src="https://github.com/user-attachments/assets/1433f6e8-40b1-449b-ab23-fcb88028433b" />



## 🚀 Cài đặt

### 1. Clone repository
```bash
git clone <repository-url>
cd App_doc_sach/App_doc_sach
```

### 2. Mở project trong Android Studio
- Mở Android Studio
- Chọn `File > Open` và chọn thư mục dự án
- Đợi Gradle sync hoàn tất

### 3. Build và chạy
- Kết nối thiết bị Android hoặc khởi động emulator
- Nhấn `Run` hoặc sử dụng phím tắt `Shift + F10`

## 📁 Cấu trúc dự án

Dự án được tổ chức theo mô hình MVC với các package: `controller`, `model`, `view`, `database`, `utils`.

## 🗄️ Database

Ứng dụng sử dụng SQLite với 5 bảng: `User`, `Book`, `Chapter`, `FavoriteBook`, `ReadingProgress`.

## 🔑 Tài khoản mặc định

- **Username**: `admin` | **Password**: `admin`

## 📝 Quyền truy cập

- `READ_EXTERNAL_STORAGE`: Đọc file PDF
- `WRITE_EXTERNAL_STORAGE`: Lưu file (Android <= 28)

## 📦 Build APK

```bash
./gradlew assembleDebug    # Debug APK
./gradlew assembleRelease  # Release APK
```

## 🔄 Phiên bản

- Version: 1.0 | Database Version: 2

---

**Lưu ý**: Cấp quyền truy cập bộ nhớ để đọc file PDF.
