package com.lex.showcase.web.servlet3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.Executor;

/**
 */
@WebServlet(urlPatterns = "/servlet", asyncSupported = true, loadOnStartup = 1)
public class AsyncDemoServlet extends HttpServlet {
    private static Logger log = LogManager.getLogger(AsyncDemoServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("进入Servlet的时间：" + new Date());
        out.flush();

        // 在子线程中执行业务调用，并由其负责输出响应，主线程退出
        AsyncContext ctx = req.startAsync();
        ctx.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent event) throws IOException {
                try {
                    Thread.sleep(2000); // 模拟资源清理工作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Complete ...");
            }

            @Override
            public void onTimeout(AsyncEvent event) throws IOException {
                log.info("Timeout ...");
            }

            @Override
            public void onError(AsyncEvent event) throws IOException {
                log.info("Error ...");
            }

            @Override
            public void onStartAsync(AsyncEvent event) throws IOException {
                log.info("StartAsync ...");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000); // 等待3秒钟以模拟业务方法的执行
                    PrintWriter out = ctx.getResponse().getWriter();
                    out.println("业务处理完毕的时间：" + new Date());
                    out.flush();
                    ctx.complete();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        out.println("结束Servlet时间：" + new Date());
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
