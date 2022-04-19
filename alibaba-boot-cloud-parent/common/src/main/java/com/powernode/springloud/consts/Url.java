package com.powernode.springloud.consts;

public class Url {
    public static final String  EUREKA_CLIENT_PROVIDER="eureka-licent-provide";

    //RestTemplate远程调用地址
    public static final String PROVIDER_01="http://localhost:7001/provider/01";
    public static final String PROVIDER_02="http://localhost:7001/provider/02/{id}/{username}";
    public static final String PROVIDER_03="http://localhost:7001/provider/03/{id}/{username}";
    public static final String PROVIDER_04="http://localhost:7001/provider/04/{id}/{username}";
    public static final String PROVIDER_05="http://localhost:7001/provider/05/{id}/{username}?state=1&power=root";
    public static final String PROVIDER_06="http://localhost:7001/provider/06/{id}/{username}?state=1&power=root";
    public static final String PROVIDER_07="http://localhost:7001/provider/07/{id}/{username}?state=1&power=root";

    //RestTemplate负载均衡调用地址
    public static final String PROVIDER_01_LOAD_BALANCED="http://eureka-licent-provide/provider/01";
    public static final String PROVIDER_02_LOAD_BALANCED="http://eureka-licent-provide/provider/02/{id}/{username}";
    public static final String PROVIDER_03_LOAD_BALANCED="http://eureka-licent-provide/provider/03/{id}/{username}";
    public static final String PROVIDER_04_LOAD_BALANCED="http://eureka-licent-provide/provider/04/{id}/{username}";
    public static final String PROVIDER_05_LOAD_BALANCED="http://eureka-licent-provide/provider/05/{id}/{username}?state=1&power=root";
    public static final String PROVIDER_06_LOAD_BALANCED="http://eureka-licent-provide/provider/06/{id}/{username}?state=1&power=root";
    public static final String PROVIDER_07_LOAD_BALANCED="http://eureka-licent-provide/provider/07/{id}/{username}?state=1&power=root";

    //Feign负载均很远程调用链接地址
    public static final String Feign_PROVIDER_01="provider/01";
    public static final String Feign_PROVIDER_02="provider/02/{id}/{username}";
    public static final String Feign_PROVIDER_03="provider/03/{id}/{username}";
    public static final String Feign_PROVIDER_04="provider/04/{id}/{username}";
    public static final String Feign_PROVIDER_05="provider/05/{id}/{username}?state=1&power=root";
    public static final String Feign_PROVIDER_06="provider/06_Feign/{id}/{username}?state=1&power=root";
    public static final String Feign_PROVIDER_07="provider/07_Feign/{id}/{username}?state=1&power=root";
}
