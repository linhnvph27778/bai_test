package com.example.demo.constant;

public class ErrorMessage {

    public static final class SAN_PHAM_ERRORS{
        public static final String ID = "id";
        public static final String NAME = "Ten San Pham";
        public static final String MOTA = "Mo ta";
        public static final String GIABAN = "Gia ban";
        public static final String SOLUONG = "Số lượng";
        public static final String KEYWORD = "Keyword";
        public static final String ID_NOT_NULL = "id không được để trống";
        public static final String ID_NOT_FOUND = "San pham có id = %s khong tồn tại";
        public static final String NAME_NOT_NULL = "Ten san pham không được để trống";
        public static final String MOTA_NOT_NULL = "Mô tả san pham không được để trống";
        public static final String GIA_BAN_NOT_NULL = "Giá bán san pham không được để trống";
        public static final String GIA_BAN_MIN = "Giá bán san pham phải lớn hơn 1000";
        public static final String SO_LUONG_MIN = "Giá bán san pham phải lớn hơn 1";
        public static final String SO_LUONG_NOT_NULL = "So luong san pham không được để trống";
        public static final String NOT_POUND_KEYWORD = "Không tìm thấy sản phẩm";
        public static final Integer MIN_PRICE = 1000;
        public static final Integer SO_LUONG_TON = 1;
    }
    public static final class DON_HANG_ERRORS{
        public static final String ID = "id";
        public static final String NAME = "Ten khacsch hang";
        public static final String DIACHI = "Dia chỉ";
        public static final String EMAIL = "Email";
        public static final String SDT = "SDT";
        public static final String NGAYTAO = "Ngày tạo";
        public static final String KEYWORD = "Keyword";
        public static final String ID_NOT_NULL = "id không được để trống";
        public static final String ID_NOT_FOUND = "Don hang có id = %s khong tồn tại";
        public static final String NAME_NOT_NULL = "Ten khách hàng không được để trống";
        public static final String DIACHI_NOT_NULL = "Địa chỉ không được để trống";
        public static final String EMAIL_NOT_NULL = "Email không được để trống";
        public static final String NGAY_TAO_NOT_NULL = "Ngày tạo không được để trống";
        public static final String EMAIL_IS_INVALID = "Email khong dung dinh dang";
        public static final String FORMAT_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        public static final String PHONE_NOT_NULL = "Phone không được để trống";
        public static final String PHONE_IS_INVALID = "Phone khong dung dinh dang";
        public static final String PHONE_IS_EXISTED = "Phone %s đã tồn tại";
        public static final String FORMAT_PHONE =  "^0[0-9]{9}$";
        public static final String GIA_BAN_NOT_NULL = "Giá bán san pham không được để trống";
        public static final String GIA_BAN_MIN = "Giá bán san pham phải lớn hơn 1000";
        public static final String SO_LUONG_MIN = "Giá bán san pham phải lớn hơn 1";
        public static final String SO_LUONG_NOT_NULL = "So luong san pham không được để trống";
        public static final String NOT_POUND_KEYWORD = "Không tìm thấy sản phẩm";
        public static final Integer MIN_PRICE = 1000;
        public static final Integer SO_LUONG_TON = 1;
    }
}
