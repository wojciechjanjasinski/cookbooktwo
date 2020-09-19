insert into recipe (dish_name, food_category, difficulty_level, time) values ('Chleb biały z automatu', 'POLSKA', 'LATWE', 100);

insert into ingredient (name, amount, unit_name, recipe_id) values('woda', 350, 'ml', 1);
insert into ingredient (name, amount, unit_name, recipe_id) values('olej', 2, 'łyżeczki', 1);
insert into ingredient (name, amount, unit_name, recipe_id) values('sól', 1.5, 'łyżeczki', 1);
insert into ingredient (name, amount, unit_name, recipe_id) values('cukier', 1, 'łyżeczka', 1);
insert into ingredient (name, amount, unit_name, recipe_id) values('mąka pszenn typ 550', 600, 'gr', 1);
insert into ingredient (name, amount, unit_name, recipe_id) values('drożdże', 50, 'gr', 1);

insert into step (description, recipe_id) values  ('nalać wody do zbiornika maszyny ', 1);
insert into step (description, recipe_id) values  ('wsypać mąkę do zbiornika', 1);
insert into step (description, recipe_id) values  ('wlać olej przy brzegu zbiornika', 1);
insert into step (description, recipe_id) values  ('wsypać sól na mąkę', 1);
insert into step (description, recipe_id) values  ('wsypać na mąkę cukier w inno miejsce niż sól', 1);
insert into step (description, recipe_id) values  ('umieść drożdże na cukrze', 1);
insert into step (description, recipe_id) values  ('uruchomić program <szybki chleb> lub podobny o czasie do 1:40 h', 1);
insert into step (description, recipe_id) values  ('Gotowe! Smacznego!', 1);

insert into recipe (dish_name, food_category, difficulty_level, time) values ('Mizeria', 'POLSKA', 'BULKA_Z_MASLEM', 10);

insert into ingredient (name, amount, unit_name, recipe_id) values('ogórki', 2, 'sztuki', 2);
insert into ingredient (name, amount, unit_name, recipe_id) values('śmietana ukwaszona', 180, 'ml', 2);
insert into ingredient (name, amount, unit_name, recipe_id) values('sól', 1, 'łyżeczka', 2);

insert into step (description, recipe_id) values  ('obrać ogórki', 2);
insert into step (description, recipe_id) values  ('pokroić ogórki nożem', 2);
insert into step (description, recipe_id) values  ('posolić ogórki', 2);
insert into step (description, recipe_id) values  ('odcisnąć ogórki i pozbądź się wody', 2);
insert into step (description, recipe_id) values  ('wymieszać ogórki ze śmietaną', 2);
insert into step (description, recipe_id) values  ('Gotowe! Smacznego!', 2);

insert into recipe (dish_name, food_category, difficulty_level, time) values ('Spaghetti Bolognese z Mascarpone', 'WLOSKA', 'LATWE', 45);

insert into ingredient (name, amount, unit_name, recipe_id) values('makaron', 300, 'gr', 3);
insert into ingredient (name, amount, unit_name, recipe_id) values('mięso mielone', 400, 'gr', 3);
insert into ingredient (name, amount, unit_name, recipe_id) values('olej', 30, 'ml', 3);
insert into ingredient (name, amount, unit_name, recipe_id) values('gotowy sos boloński', 400, 'gr', 3);
insert into ingredient (name, amount, unit_name, recipe_id) values('ser Mascarpone', 250, 'gr', 3);

insert into step (description, recipe_id) values  ('ugotować makaron zgodnie z instrukcją producenta i według własnych upodobań', 3);
insert into step (description, recipe_id) values  ('w czasie gotowania makaronu podsmażyć mięso na patelni na oleju aż do wytracenia przez nie wody', 3);
insert into step (description, recipe_id) values  ('odcedzić makaron', 3);
insert into step (description, recipe_id) values  ('dodać sos boloński do mięsa, wymieszać zagrzać przez kilka minut do zagotowania', 3);
insert into step (description, recipe_id) values  ('dodać ser Mascarpone do mięsa podgrzać przez chwilę i wymieszać aż do całkowitego rozpuszczenia i uzyskania jednolitej barwy', 3);
insert into step (description, recipe_id) values  ('dodać ugotowany makaron i wymieszać', 3);
insert into step (description, recipe_id) values  ('Gotowe! Smacznego!', 3);

insert into recipe (dish_name, food_category, difficulty_level, time) values ('Sernik czekoladowy', 'SLODKIE', 'SREDNIOWYMAGAJACE', 70);

insert into ingredient (name, amount, unit_name, recipe_id) values('ser biały', 80, 'dag', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('jajka', 3, 'szt', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('masło', 2, 'łyżki', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('czekolada gorzka', 200, 'gr', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('czekolada biała', 200, 'gr', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('cukier kryształ', 165, 'gr', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('orzechy włoskie', 5, 'dag', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('herbatniki', 20, 'dag', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('ptasie mleczko', 1, 'opakowanie', 4);
insert into ingredient (name, amount, unit_name, recipe_id) values('tłuszcz do formy', 30, 'ml', 4);

insert into step (description, recipe_id) values  ('Tortownicę wysmarować tłuszczem.', 4);
insert into step (description, recipe_id) values  ('Orzechy zmielić z herbatnikami , rozetrzeć z masłem i rozłożyć w tortownicy.', 4);
insert into step (description, recipe_id) values  ('Ser zmiksować z jajami i cukrem- podzielić na pół.', 4);
insert into step (description, recipe_id) values  ('Czekolady połamać i osobno stopić.', 4);
insert into step (description, recipe_id) values  ('Połowę masy serowej wymieszać z czekoladą ciemną, a połowę z jasną.', 4);
insert into step (description, recipe_id) values  ('Do tortownicy włożyć ciemną masę serową , po czym rozłożyć ptasie mleczko i przykryć jasną masą serową.', 4);
insert into step (description, recipe_id) values  ('Wstawić do nagrzanego piekarnika 160 stopni i piec około 50 minut.', 4);
insert into step (description, recipe_id) values  ('Gotowe! Smacznego', 4);
insert into step (description, recipe_id) values  ('przepis niemal nie zmieniony za: https://smaker.pl/przepisy-desery/przepis-sernik-czekoladowy,119175,tradycyjna-kuchnia.html', 4);