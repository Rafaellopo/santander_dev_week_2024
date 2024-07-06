package me.dio.santander_dev_week_2024.service.exeception;

public class NotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public NotFoundException() {
        super("Resource not found.");
    }
}
