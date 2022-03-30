package com.hjl.Controller;


import com.hjl.Bean.DataTest;
import com.hjl.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

@RestController
@RequestMapping("/Data")
public class DataController {

    static int cpuNum = Runtime.getRuntime().availableProcessors();

    @Resource
    private DataService dataService;

//    @RequestMapping(value = "/select/{limit}",method = RequestMethod.GET)
//    public List<DataTest> select(@PathVariable("limit") long limit) throws ExecutionException, InterruptedException {
//        long start;
//        long end;
//        System.out.println(start=System.currentTimeMillis());
//        long Count = dataService.getCount();
//        List<FutureTask<List<DataTest>>> list = new ArrayList<>();
//        long num = (Count / limit);
//        for (int i=0;i<num;i++) {
//            long index = i * limit;
//            FutureTask<List<DataTest>> futureTask = new FutureTask<>(
//                    () -> dataService.selectAll(index, limit)
//            );
//            new ThreadPoolExecutor(10,10000,3,TimeUnit.SECONDS,new ArrayBlockingQueue<>(50)).execute(futureTask);
//            list.add(futureTask);
//        }
//        List<DataTest> res = new ArrayList<>();
//        while (list.size() > 0){
//            Iterator<FutureTask<List<DataTest>>> iterator = list.iterator();
//            while (iterator.hasNext()){
//                res.addAll(iterator.next().get());
//                iterator.remove();
//            }
//        }
//        end=System.currentTimeMillis();
//        System.out.println(end-start);
//        System.out.println(res.size()+"|"+Count);
//        return res;
//    }

    @RequestMapping(value = "/selectAll/{limit}",method = RequestMethod.GET)
    public List<DataTest> selectAllN(@PathVariable("limit") long limit) throws ExecutionException, InterruptedException {
        long start;
        long end;
        System.out.println(start=System.currentTimeMillis());
        long Count = dataService.getCount();
        List<FutureTask<List<DataTest>>> list = new ArrayList<>();
        long num = (Count / limit);
        for (int i=0;i<num;i++) {
            long index = i * limit;
            FutureTask<List<DataTest>> futureTask = new FutureTask<>(
                    () -> dataService.selectAllN(index,limit)
            );
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                    (cpuNum * 2),Integer.MAX_VALUE,60,TimeUnit.SECONDS,new ArrayBlockingQueue<>(500)
            );
            threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(futureTask);
            list.add(futureTask);
            System.out.println("index:"+index+"| "+limit+" || "+Thread.currentThread().getId());
        }
        //接受返回的结果（list）
        List<DataTest> res = new ArrayList<>();
        while (list.size() > 0){
            Iterator<FutureTask<List<DataTest>>> iterator = list.iterator();
            while (iterator.hasNext()){
                res.addAll(iterator.next().get());
                iterator.remove();
            }
        }
        if(res.size() != Count){
            res.addAll(dataService.selectRemainder(Count-res.size()));
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(res.size()+"|"+Count);
        return res;
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public List<DataTest> selectO() throws ExecutionException, InterruptedException {
        long start;
        long end;
        System.out.println(start=System.currentTimeMillis());
        List<DataTest> list = dataService.queryAll();
        end=System.currentTimeMillis();
        System.out.println((end-start)+"|"+"|"+list.size());
        return list;
    }


}
