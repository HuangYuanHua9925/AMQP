�}�)     b�8Y�YĐj�u
��� �a9��T�o�Ҭ˦z�t����~Xs4�9�S�i�,V�ɏ����M�)�@�O��e�c7�Q�Q��w��X�ǩ��%3��}���OL�)�.�[rgK�|Y�.���8�IA����A�K ����{���N�A���#��G�;��q�2dp>�/�T�7�`>yC*~*��0I~/�5cX
��z�ɝS����wr'9vM�� ��&*��Xh���ZlD�9�</�bm��{2'��ϖa��a�H��;)S��ԳL��P��|�� �`nl5��vp�ګdx;C"�B��P�����ߨ�$E�֤�s���J�:��	��]Ger�߼�*�jSʻē��]��(�d�ABG��ĹXE�%��κ|�����]�ଁJ��z �*{�=nܷv8�"�v�7��>�5��AbI!�������
��,2����58��
�ڑmHr�gޒ3�ᕿ{H��éX{��jitTemplate = context.getBean(RabbitTemplate.class);
		int i = 1;
		synchronized (rabbitTemplate) {

			while (true) {

				String str = "hello :" + i;
				// 需要指定exchange和routingKey
				rabbitTemplate.send("exchange", "spittle.yuan",
						new Message(str.getBytes(), new MessageProperties()));
				i++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
