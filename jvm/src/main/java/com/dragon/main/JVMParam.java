package com.dragon.main;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @Descreption TODO
 * @Author shizhongxu3
 * @Date 2023/3/3 17:05
 * @Version 1.0
 **/
public class JVMParam {

    public static void main(String args[]) {

        List<GarbageCollectorMXBean> l = ManagementFactory.getGarbageCollectorMXBeans();
        assert (l != null && l.size() ==2);
        assert(l.size() == 2);

        for (int i = 0; i < l.size(); i++) {
            GarbageCollectorMXBean garbageCollectorMXBean = l.get(i);
            if (i == 0){
                System.out.println("young generation is:" + garbageCollectorMXBean.getName());
            }else if (i == 1){
                System.out.println("old generation is:" + garbageCollectorMXBean.getName());
            }
        }
    }

}
