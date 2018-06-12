       InputStream lInputStream = aInContainerRequestContext.getEntityStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(lInputStream);
        int DEFAULT_BUFFER_SIZE = 8192;
        bufferedInputStream.mark(DEFAULT_BUFFER_SIZE);
        byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
        int read;
        try {
            read = bufferedInputStream.read(bytes, 0, DEFAULT_BUFFER_SIZE);
            bufferedInputStream.reset();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        aInContainerRequestContext.setEntityStream(bufferedInputStream);

        String m = new String(bytes,"UTF-8");
        System.out.println(m);
