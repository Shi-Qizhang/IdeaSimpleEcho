# IdeaSimpleEcho
just  a demo
服务端的实现:
    public class EchoServer{
        //创建一个serverSocket
        private final ServerSocket serverSocket;
        //创建一个构造器 传入端口
        public EchoServer(int port) throws IOException{
             //创建服务端    这里相当于创建了一个服务器并开启了通信端口port
            serverSocket = new ServerSocket(port);
            
        }
        //开始等待并接受客户端连接
        public void run() throws IOException(){
             //等待客户端的信息   如果客户端长时间没有与它建立连接  将会抛出异常 异常是在jdk中封装了的
             Socket  client = serverSocket.accept();
             //进行socket通信处理
             handleClient(client);
        
        
        }
        //进行socket通信
        private void handleClient(Socket socket) throws IOException(){
        
        
            //获取输入流
            InputStream in = socket.getInputStream();
            //输出流
            OutPutStream out = socket.getOutputStream();
            //设置缓冲区  1024个字节
            byte[] buffer = new byte[1024];
            //输出流的长度
            int n;
            //不断读入来自客户端的数据流  然后写回给客户端
            while((n=in.read(buffer))>0){
            
                out.write(buffer,0,n);
               
            
            }
            
        
        
        }
    
    
    public static void main(String[] args){
    
        try{
            //开启客户端 设置端口为9000
            EchoServer server = new EchoServer(9000);
            //运行服务端
            server.run();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    
    }
    
    }
客户端的实现:
     public class EchoClient{
         //创建socket
         private final Socket socket;
         
         //和服务端进行通信
         
         pubic void run throws IOException(){
             //创建一个线程和服务端进行通信
             Thread readThread = new Thread(this::readResponse);
             //使用了lambda表达式相当于
             /*
                Thread  readThread = new Thead(new Runnable(){
                
                    @Override
                    public void run(){
                        
                        readResponse();
                    
                    }
                
                });*/
                
                
                 //开启线程
                readThread.start();
                //设置输出流
                outputStream in = socket.getOutputStream();
                //创建缓冲区
                byte[] byte = new Byte[1024];
                //设置流的长度
                int n;
                //不断读取来自于服务端的流信息  并不断显示在客户端屏幕上
                while((n=System.read(buffer))>0){
                    out.write(buffer,0,n);
                }
             
         }
         
         
         
         public void readResonse(){
             
             try{
                 //创建输入流对象
                 InputStram in = socket.getInputStream();
                 
                 //创建缓冲区
                 byte[] buffer = new byte[1024];
                 //设置流的长度
                 int n;
                 //读取流 并不断向服务端写入数据
                 while((n=in.read(buffer))>0){
                 
                     System.out.write(buffer,0,n);
                     
                 
                 }
                  
             
             }catch(IOException e){
             
                 e.printStackTrace();
             }
         
         
             
         }
     
     
     public static void main(String[] args){
     
         try{
             EchoClient client = new EchoClient("localhost",9000);
             client.run();
             
         
         }catch(IOException e){
         
             e.printStackTrace();
         }
         
     }
     
     }
