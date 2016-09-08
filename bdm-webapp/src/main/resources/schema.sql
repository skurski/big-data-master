DROP DATABASE IF EXISTS solrexample;
CREATE DATABASE solrexample;
USE solrexample;

CREATE TABLE IF NOT EXISTS product (
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(40) NOT NULL,
  code VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS detail (
  id INT AUTO_INCREMENT NOT NULL,
  product_id int NOT NULL,
  price FLOAT NOT NULL,
  quantity INT NOT NULL,
  snippet text NOT NULL,
  description text NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS supplier (
  id INT AUTO_INCREMENT NOT NULL,
  product_id INT NOT NULL,
  name VARCHAR(40) NOT NULL,
  code VARCHAR(40) NOT NULL,
  description text NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product VALUES (1, 'Huawei P8 Lite', '0001');
INSERT INTO product VALUES (2, 'Galaxy 3', '0002');
INSERT INTO product VALUES (3, 'Iphone S6', '0003');
INSERT INTO product VALUES (4, 'Redmi', '0004');

INSERT INTO detail VALUES (1, 1, 599.90, 12, 'Superb Huawei', 'Brilliant thoughts and bright ideas create smart technology. Inside the P8 lite glows a powerful 1.5GHz processor that allows multi-tasking and lightning-fast response times between actions. Ultra Power-Saving Mode manages battery life so your device keeps going long after the sun goes down.');
INSERT INTO detail VALUES (2, 2, 199.90, 12, 'Old Samsung', 'Work, rest and play with the Samsung Galaxy S7 edge. A massive 5.5-inch Super AMOLED touchscreen goes all the way to the edges of the phone so that you get the maximum area possible to work with. Solid water resistance, great processing and masses of memory round out this Samsung Galaxy S7 edge.');
INSERT INTO detail VALUES (3, 3, 399.90, 12, 'Classic Iphone', 'The moment you use iPhone 6s, you know you’ve never felt anything like it. With a single press, 3D Touch lets you do more than ever before. Live Photos bring your memories to life in a powerfully vivid way. And that’s just the beginning. Take a deeper look at iPhone 6s, and you’ll find innovation on every level.');
INSERT INTO detail VALUES (4, 4, 999.90, 12, 'Surprise Redmi', 'Redmi Note 3 is really fast—flagship fast. The high-performance Snapdragon 650 processor uses ARM''s flagship Cortex-A72 cores to launch apps in a split-second. Its next-gen Adreno 510 graphics processor delivers a fluid gaming experience. The hexa-core processor delivers up to 1.8GHz clock speed, supports dual-channel memory and eMMC 5.0 flash. Combined with MIUI 7''s system-level speed optimizations, Redmi Note 3 responds to every touch in a snap.');

INSERT INTO supplier VALUES (1, 1, 'Google', '01', '');
INSERT INTO supplier VALUES (2, 2, 'Samsung', '02', '');
INSERT INTO supplier VALUES (3, 3, 'Apple', '03', '');
INSERT INTO supplier VALUES (4, 4, 'Chinese factory', '04', '');