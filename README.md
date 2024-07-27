# Couchbase Demo Uygulaması

Bu uygulama, Couchbase veritabanını kullanarak kitap koleksiyonunu yönetmek için basit bir RESTful API sağlar. Kitap kayıtlarını oluşturma, alma, güncelleme ve silme işlemleri için endpoint'ler sunar.

### Özellikler

 - **CRUD İşlemleri**: Kitap oluşturma, okuma, güncelleme ve silme.
 - **Couchbase Entegrasyonu**: Veri depolama için Couchbase ile sorunsuz entegrasyon.
 - **Hata Yönetimi**: Hataları uygun hata yanıtları ile zarif bir şekilde ele alır.
 - **İstek Doğrulama**: Gelen istekler için veri bütünlüğünü ve geçerliliğini sağlar.

### Endpoint'ler

- **GET /api/books**: Tüm kitapları alır.
- **GET /api/books/{id}**: Belirli bir kitabı kimliğine göre alır.
- **POST /api/books**: Yeni bir kitap oluşturur.
- **PUT /api/books**: Mevcut bir kitabı günceller.
- **DELETE /api/books**: Bir kitabı kimliğine göre siler.

### Konfigürasyon
Uygulama, Couchbase bağlantı ayrıntıları için application.yaml dosyasını kullanarak yapılandırılmıştır:

    spring: 
	    datasource: 
		    couchbase: 
			    host: 127.0.0.1 
				bucket: 
				    username: yourusername
				    password: yourpassword
				    name: yourbucketname
