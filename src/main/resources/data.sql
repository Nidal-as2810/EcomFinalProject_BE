DROP TABLE IF EXISTS user;

CREATE TABLE user (
     id int(11) unsigned NOT NULL AUTO_INCREMENT,
     username varchar(24) NOT NULL DEFAULT '',
     password varchar(24) NOT NULL DEFAULT '',
     active tinyint(1) NOT NULL DEFAULT '1',
     roles varchar(200) NOT NULL DEFAULT '',
     permissions varchar(200) NOT NULL DEFAULT '',
     PRIMARY KEY (id)
);

INSERT INTO user (username, password, active, roles, permissions) VALUES
    ('admin', 'admin', 1, '', ''),
    ('nidal', '1234', 1, '', '');

CREATE TABLE user_info(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    firstname varchar(20) NOT NULL DEFAULT '',
    lastname varchar(20) NOT NULL DEFAULT '',
    email varchar(100) NOT NULL DEFAULT '',
    state varchar(30) NOT NULL DEFAULT '',
    city varchar(30) NOT NULL DEFAULT '',
    phone varchar(15) NOT NULL DEFAULT '',
    address varchar(150) NOT NULL DEFAULT '',
    user_id int(11) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE category(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    category_name varchar(50) NOT NULL DEFAULT '',
    category_name_ar varchar(50) NOT NULL DEFAULT '',
    category_name_he varchar(50) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

INSERT INTO category(category_name,category_name_ar,category_name_he) VALUES
('fashion','موضة','אופנה'),
('electronics','إلكترونيات','מכשירי חשמל'),
('accessories','مستلزمات','אביזרים'),
('home','بيت','בית');

CREATE TABLE subcategory(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    sub_name varchar(50) NOT NULL DEFAULT '',
    sub_name_ar varchar(50) NOT NULL DEFAULT '',
    sub_name_he varchar(50) NOT NULL DEFAULT '',
    category_id varchar(24) NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);
INSERT INTO subcategory(sub_name,sub_name_ar,sub_name_he,category_id) VALUES
('mens clothes','ملابس رجالية','בגדי גברים',1),
('womens clothes','ملابس نسائية','בגדי נשים',1),
('boys clothes','ملابس الأولاد','בגדי בנים',1),
('girls clothes','ملابس بنات','בגדי בנות',1),
('computers','أجهزة الكمبيوتر','מחשבים',2),
('cellulars','الخلوية','סלולר',2),
('televisions','التلفزيونات','טלוויזיות',2),
('bags & wallets','الحقائب والمحافظ','תיקים וארנקים',3),
('laptop bags','حقائب الكمبيوتر المحمول','תיקים למחשב נייד',3),
('furniture','أثاث المنزل','רְהִיטִים',4),
('bedding','الفراش','מצעים',4);


CREATE TABLE item(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL DEFAULT '',
    description varchar(150) NOT NULL DEFAULT '',
    price decimal NOT NULL DEFAULT 0.0,
    quantity int(6) NOT NULL DEFAULT 0,
    unit varchar(10) NOT NULL DEFAULT '',
    image varchar(MAX) NOT NULL DEFAULT '',
    subcategory_id int(11) NOT NULL,
    is_favourite varchar(25) NOT NULL DEFAULT 'no',
    PRIMARY KEY (id),
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(id)
 );

INSERT INTO item(name,description,price,quantity,unit,image,subcategory_id,is_favourite) VALUES
('shirt','casual mens long sleeve slim shirt.',13.9,74,'piece','https://images-eu.ssl-images-amazon.com/images/I/51nIfK1492L.jpg',1,'no'),
('paris trousers','casual mens cotton trousers.',18.75,94,'piece','https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/1420fc18-a073-45e2-af6b-548de48ee387/paris-saint-germain-trousers-8Rfs8f.png',1,'no'),
('sweater','casual mens long sleeves slim cotton sweater.',27.3,94,'piece','https://s3.eu-central-1.amazonaws.com/www1.partseurope.eu/products/3c454d248a273186f9fd0435ee8c6267.png',1,'no'),
('sweater','casual mens long sleeves slim cotton sweater.',27.3,94,'piece','https://s3.eu-central-1.amazonaws.com/www1.partseurope.eu/products/3c454d248a273186f9fd0435ee8c6267.png',1,'no'),
('cartoon computer','nice looking cartoon never would be used computer .',127.3,800,'piece','https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Desktop_computer_clipart_-_Yellow_theme.svg/2000px-Desktop_computer_clipart_-_Yellow_theme.svg.png',5,'no'),
('ancient computer','first computer ever.',1427.3,1800,'piece','https://www.butterflyedufields.in/wp-content/uploads/2019/02/How-does-a-Computer-work1.jpg',5,'no'),
('iphone 13 pro','5g 128gb.',1477.3,100,'piece','https://eluldigital.co.il/wp-content/uploads/apple-iphone-13-pro-2.jpg',6,'no'),
('galaxy s22','256gb 12gb ram.',1127.3,10,'piece','https://d3m9l0v76dty0.cloudfront.net/system/photos/8989877/original/fd25c848286f1cb8d0e7cdd18a485724.jpg',6,'no'),
('huawei mate','huawei mate 50 pro.',1007.0,80,'piece','https://img01.huaweifile.com/sg/ms/sa/pms/uomcdn/SA_HW_B2C/pms/202211/gbom/6941487285808/428_428_454DEE8EAB2BD28AECF6EDA9002AA13Bmp.jpg',6,'no'),
('galaxy z','fold 4.',2427.4,110,'piece','https://images.samsung.com/il/smartphones/galaxy-z-fold4/images/galaxy-z-fold4_highlights_kv.jpg',6,'no'),
('Samsung 86"','led 4k uhd smart tizen tv.',578.2,8,'piece','https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6465/6465204cv11d.jpg',7,'no'),
('HelloKimi','HelloKimi Lightweight Water Resistant Preschool Backpack for Kids Toddlers Kindergarten School Bag Cartoon Bag.',7.59,200,'piece','https://static-01.daraz.lk/p/d395d50501696ac60870bc642a9f80bd.jpg',8,'no'),
('Herschel','Herschel Supply Co. Novel Duffel Bag, Black/Black, One Size.',27.0,30,'piece','https://m.media-amazon.com/images/I/81J0UV54ILL._AC_SY879_.jpg',8,'no'),
('Laptop Backpacks','A structured and sophisticated bag that does not skimp on comfort: Troubadour Apex Backpack.',45.0,18,'piece','https://cdn.thewirecutter.com/wp-content/media/2022/12/laptopbackpacks-2048px-6879.jpg?auto=webp&quality=75&width=1024',9,'no'),
('Acanva','Acanva Mid Century Modern Curved Living Room Sofa, 4-Seat Boucle Fabric Couch for Bedroom, Office, Apartment, White.',1427.3,1800,'piece','https://m.media-amazon.com/images/I/7155Nkmgs-L.jpg',10,'no'),
('bed room','sleep.',1427.3,1800,'piece','https://furnitureholz.com/wp-content/uploads/2021/04/bedset-furniture-holz-1-1.jpg',10,'no'),
('coffee table','drink.',1427.3,1800,'piece','https://b2cfurniture.com.au/pub/media/b2cfurniture/homepage/Dining-Furniture.png',10,'no'),
('duvet cover','bed time.',12,30,'piece','https://media.glamourmagazine.co.uk/photos/6205376a5cb4c1bd0933388c/16:9/w_1920,h_1080,c_limit/BEDDING%20100222%20SQUARE.jpg',11,'no'),
('chaos','dont try this at home.',4.3,40,'piece','https://i.pinimg.com/736x/58/e0/59/58e0592c96c516b8272cd2124a902208.jpg',11,'no');

CREATE TABLE orderTBL(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    order_date DATE NOT NULL,
    user_id int(11) NOT NULL,
    total FLOAT NOT NULL DEFAULT 0,
    type varchar(10) NOT NULL DEFAULT '',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE orderItem(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    item_id int(11) NOT NULL,
    order_id int(11) NOT NULL,
    qty int(5) NOT NULL DEFAULT 0,
    price FLOAT NOT NULL DEFAULT 0,
    total FLOAT NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES item(id),
    FOREIGN KEY (order_id) REFERENCES orderTBL(id)
);

CREATE TABLE favourites(
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    item_id int(11) NOT NULL,
    username varchar(25) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES item(id)
);
