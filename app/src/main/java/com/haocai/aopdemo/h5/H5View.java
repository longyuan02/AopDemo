package com.haocai.aopdemo.h5;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.haocai.aopdemo.R;
import com.haocai.aopdemo.login.LoginClose;

public class H5View extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        webView = findViewById(R.id.web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);//支持js调用window.open方法
        webSettings.setAllowFileAccess(true);// 设置允许访问文件数据
        webSettings.setSupportMultipleWindows(true);// 设置允许开启多窗口
        webSettings.setDomStorageEnabled(true);//
        webSettings.setJavaScriptEnabled(true);// 设置支持javascript
        webView.setWebViewClient(new WebViewClient() {
            private String startUrl;

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.loadUrl(request.getUrl().toString());
                }
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                startUrl = url;
//                webView.loadUrl("javascript: $(document).ready(function(){\n" +
//                        "$(\"#index-bn\").bind(\"click\", function() {\n" +
//                        "    window.open(\"http://www.sina.com\",\"_self\");\n" +
//                        "});\n" +
//                        "});");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript: $(document).ready(function(){\n" +
                        "$(\"#index-bn\").bind(\"click\", function() {\n" +
                        "    window.open(\"http://www.sina.com\",\"_blank\");\n" +
                        "});\n" +
                        "});");
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                finish();
                return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
            }
        });
        webView.loadUrl("http://www.baidu.com");
    }

    @LoginClose(close = true)
    @Override
    protected void onPause() {
        super.onPause();
    }
}
