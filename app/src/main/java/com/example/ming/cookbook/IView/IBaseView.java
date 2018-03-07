package com.example.ming.cookbook.IView;

/**
 * Created by 17111862 on 2018/2/7.
 */

public interface IBaseView<T> {
    /**
     * 加载监听
     *
     * @param isLoading true 正在加载
     */
    void onLoading(boolean isLoading);

    /**
     * 成功
     *
     * @param data 数据源
     */
    void onSuccess(T data);

    /**
     * 失败
     *
     * @param errorMsg  错误信息
     * @param errorCode 错误码
     */
    void onError(String errorMsg, int errorCode);
}
