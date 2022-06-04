-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 19, 2022 lúc 09:22 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `movie`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `maphim` int(11) NOT NULL,
  `tenphim` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `giaphim` int(11) NOT NULL,
  `soluongphim` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `maphim`, `tenphim`, `giaphim`, `soluongphim`) VALUES
(1, 1, 1, 'Avatar', 50000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `sodienthoai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`) VALUES
(1, 'Nguyễn Văn A', '0231242322', 'nguyenvana@email.com'),
(2, 'abc', '0123124124', 'abc@gmail.com');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaiphim`
--

CREATE TABLE `loaiphim` (
  `id` int(11) NOT NULL,
  `tenloaiphim` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hinhanhloaiphim` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaiphim`
--

INSERT INTO `loaiphim` (`id`, `tenloaiphim`, `hinhanhloaiphim`) VALUES
(1, 'Hành động', 'https://dbk.vn/uploads/ckfinder/images/tin-tuc-1/phim-hanh-dong-3.jpg'),
(2, 'Khoa học viễn tưởng', 'https://3.bp.blogspot.com/-Abv_w4_nQ9Y/WwbOmrYNWJI/AAAAAAAAPRo/NiTsd3-BBwoWE4VQg_rdGyyOs_0pLtlJQCLcBGAs/s1600/starwars.jpeg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phim`
--

CREATE TABLE `phim` (
  `id` int(11) NOT NULL,
  `tenphim` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `giaphim` int(11) NOT NULL,
  `hinhanhphim` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mota` varchar(10000) COLLATE utf8_unicode_ci NOT NULL,
  `idphim` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phim`
--

INSERT INTO `phim` (`id`, `tenphim`, `giaphim`, `hinhanhphim`, `mota`, `idphim`) VALUES
(1, 'Avatar', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTa22GoVnHRiqDeG2EYVdgDwZdzZiXQYWAizQ&usqp=CAU', 'Bối cảnh trong phim diễn ra tại hành tinh Pandora xinh đẹp, nơi có những khu rừng nhiệt đới kỳ ảo, những cây cổ thụ khổng lồ, những loài sinh vật mạnh mẽ, hung dữ và đặc biệt là chủng tộc người da xanh Na\'vi. Ở Pandora có mỏ khoáng chất quý hiếm Unobtainium - được coi như chiếc chìa khóa cho cuộc khủng hoảng năng lượng tại Trái đất vào thế kỷ 22. Đó chính là lý do khiến con người đổ bộ xuống Pandora và bỏ ra hàng trăm tỷ đôla để tìm cách xâm chiếm và khai thác nguồn khoáng chất này. Nhưng việc con người xuất hiện tại nơi đây đã phá tan sự yên bình của chủng tộc người Na\'vi và có nguy cơ làm nổ ra cuộc chiến tranh tàn khốc. Jake Sully - cựu quân nhân bị thương và phải gắn mình với chiếc xe lăn, do sở hữu bộ gene giống với người em sinh đôi đã chết nên đã thay em trai thực hiện sứ mệnh Avatar cho phép con người điều khiển một hiện thân lai tạo giữa ADN của người Trái đất và người Na\'vi, từ đó thâm nhập vào cư dân bản địa và tìm cách thôn tính Pandora. Trong hiện thân mới, Jake đã được Neytiri - công chúa của thị tộc Omaticaya cứu sống và từ đó, anh bước vào cuộc phiêu lưu của thử thách, của lý trí, của tình yêu và định mệnh.', 2),
(2, 'Quá nhanh quá nguy hiểm 7', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxryu_OjJNdQNgY7oGig4Q3zahYlz--9pfMw&usqp=CAU', 'Phim Quá Nhanh Quá Nguy Hiểm 7 trong phần này Ian Shaw tìm cách trả thù Dominic Toretto và nhóm của hắn về cái chết của anh trai mình. Hai anh em của Paul Walker sẽ là diễn viên đóng thế anh sau khi Paul Walker qua đời. sẽ quay lại với những khuôn mặt quen thuộc đã làm nên thương hiệu cho bộ phim: Vin Diesel, Paul Walker, Dwayne Johnson… và đặc biệt với phần 7 này sẽ thêm 1 cái tên nữa bảo chứng cho các pha hành động mãn nhãn của Fast 7 là Jason Statham.', 1),
(3, 'Venom', 70000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQb28xV04nM1dg_6iwXJ8fZyKtG6ZaxnEIYesao7Yz3kGNuAGY9StwT_cjkuFu2nZEokVg&usqp=CAU', 'Venom là một phim siêu anh hùng của Mỹ dựa trên nhân vật cùng tên của Marvel Comics, do Columbia Pictures sản xuất và Sony Pictures Releasing phát hành. Nó được dự định là bộ phim đầu tiên trong Thế giới Marvel của Sony, được hỗ trợ nhưng tách biệt khỏi Vũ trụ Điện ảnh Marvel (MCU).[a] Đạo diễn phim này là Ruben Fleischer với kịch bản của Scott Rosenberg, Jeff Pinkner, Kelly Marcel và Will Beall, với diễn viên Tom Hardy trong vai Eddie Brock / Venom, cùng với Michelle Williams, và Riz Ahmed.', 2),
(4, 'Thor - Tận thế ragnarok', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSy49QDk3iE4W9IndwxzsZQUzH7HJN8--KfjlVJwNwgwlUCaEqcM5pwwN5RqS60TAvG-qQ&usqp=CAU', 'Thor: Tận thế Ragnarok là một bộ phim siêu anh hùng ra mắt vào năm 2017 của Mỹ do Marvel Studios sản xuất và Walt Disney Studios Motion Pictures phân phối. Bộ phim là phần tiếp theo của Thor (2011) và Thor: The Dark World (2013) và là bộ phim thứ mười bảy trong Vũ trụ Điện ảnh Marvel (MCU). Phim do Taika Waititi làm đạo diễn, dựa trên kịch bản của Stephany Folsom, với sự góp mặt của các diễn viên như Chris Hemsworth, Tom Hiddleston, Idris Elba, Anthony Hopkins, Cate Blanchett, Tessa Thompson, Jeff Goldblum, Karl Urban và Mark Ruffalo. Trong phim, Thor phải tìm cách trốn thoát khỏi hành tinh Sakaar để kịp thời cứu Asgard khỏi Hela và ngày tận thế Ragnarok.', 2),
(5, 'Truy tìm tượng Phật 1', 50000, 'https://luotphimtv.com/wp-content/uploads/2021/07/Truy-Tim-Tuong-Phat-1.jpg', 'Phim Truy Lùng Tượng Phật - Ong Bak: The Muay Thai Warrior (2003): Phim Truy Lùng Tượng Phật 1 một chàng trai tỉnh lẻ, tình nguyện lên thành phố tìm lại đầu pho tượng phật thiêng liêng bị đám tội phạm cướp đi. Sự giúp đỡ (vô dụng) của gã đồng hương đẩy Ting vào những cuộc đấu bất hợp pháp. Sala Phim chúc bạn xem phim Truy Tìm Tượng Phật vui vẻ!', 1),
(6, 'Star Wars - The Rise of Skywalker', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRF6ZRbqAoQrCvS8b-z6Woyy8VzB-Mc6sA5og&usqp=CAU', 'Bộ phim \"Star Wars: The Rise of Skywalker\" đã tiếp tục thu về thêm khoảng 73,6 triệu USD trong 3 ngày cuối tuần qua để trụ vững vị trí đầu bảng những bộ phim ăn khách nhất tại Bắc Mỹ.\r\n\r\nTrong khi đó, \"bom tấn\" mới của hãng phim Disney cũng đã mang về thêm 94,3 triệu USD từ 52 thị trường ngoài Bắc Mỹ, theo đó nâng tổng doanh thu toàn cầu của bộ phim đạt 725 triệu USD.', 2),
(7, 'Star Wars', 70000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKCcPfTBBvnwnqRImjoi-8iwzN02vc5YiWrw&usqp=CAU', 'Nói sơ về loạt phim, khi George Lucas sáng tạo phim Star Wars thì tập đầu tiên được làm lại là phần 4: A New Hope, ra rạp hồi năm 1977, sau đó lần lượt phần 5 – The Empire Strikes Back (1980) và 6 – Return of the Jedi được làm vào năm 1983. Người ta gọi đó là “Bộ 3 tập Star Wars gốc – The Original Triology”.\r\n\r\nMãi sau này tới năm 1999, George Lucas làm tiếp 3 phần nữa nhưng lại lấy mốc thời gian trước phần 4, do đó người ta gọi bộ 3 này là prequel, thứ tự gồm phần 1: The Phantom Menace, tiếp theo sau là phần 2: Attack of The Clones vào năm 2002 và phần 3: Revenge of the Sith năm 2005. Cuối cùng là bộ 3 phần 7: the Force Awakens (2015), phần 8: the Last Jedi (2017) và phần 9: The Rise of Skywalker (2019).', 2),
(8, 'Black Widow', 70000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMHrRzRk3O8wfVgRq9I4NyFydk-LLgyzk8og&usqp=CAU', 'Trong Black Widow, gã sử dụng cung tên như Hawkeye (Jeremy Renner) và đây có thể là tình tiết chìa khóa về mối quan hệ giữa Nat với Clint, cũng như về cuộc chiến ở Budapest mà hai người từng nhắc tới trong The Avengers (2012).\r\n\r\nScarlett Johansson từng chia sẻ rằng Black Widow trong bộ phim riêng hoàn toàn rơi vào thế bí, không thể nhờ cậy các đồng đội ở nhóm Avengers. Và thử thách lớn nhất dành cho đả nữ chính là đối diện với bản thân.', 2),
(9, 'Quá nhanh quá nguy hiểm 5', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFh17PC22iJHRiQb5DxbylSsYYwznI1v-qfw&usqp=CAU', 'Brian O\'Conner là một cảnh sát giỏi bị mất chức chỉ vì bọn tội phạm đã sử dụng những thủ đoạn quá tinh vi. Và nay anh có cơ hội chuộc lại lỗi lẫm với cuộc thử thách lần hai. Để thực hiện nhiệm vụ của mình, Brian O\'Conner phải gia nhập hội đua xe trái phép trên các đường phố Miami để tìm kiếm tung tích Carter Verone, một tên tội phạm chuyên buôn ma tuý và rửa tiền. Anh và cậu bạn thân Roman Pearce được giao nhiệm vụ chuyển số tiền phi pháp cho Carter Verone hiện đang núp dưới danh nghĩa một thương gia xuất nhập khẩu ở Miami. Ngoài Roman Pearce, Brian O\'Conner còn nhận được sự giúp đỡ của nữ mật vụ tài năng và hấp dẫn, Monica Clemente, trong vai người yêu bất đắc dĩ của Carter Verone. Và cuộc phiêu lưu cùng những pha rượt đuổi bắt đầu...', 1),
(10, 'Quá nhanh quá nguy hiểm 6', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3iUFOY6IMCdBJiigjN03iyyTMLhcBF2bXZQ&usqp=CAU', 'Since Dom (Diesel), Brian’s (Walker) cùng những anh hùng của chúng ta chia sẽ phần tiền 100 triệu đô mà họ đã lấy được và tản ra khắp nơi trên thế giới. Thế nhưng số tiền mà họ nhận được chưa đủ để họ có thể sống và lo cho gia đình trong một thời gian dài vì thế từng người họ cũng đã lên kế hoạch riêng cho mình. Trong khi đó, viên cảnh sát Hobbs (Johnson) đã phát hiện, điều tra, và lần theo một tổ chức phi chính phủ chuyên vận chuyển tiền phi pháp xuyên khắp 12 quốc gia lân cận với số tiền lên đến hàng trăm tỉ đô la. Chưa dừng ở đó, tổ chức này còn trang bị cho mình \"binh đoàn\" hộ tống chuyên nghiệp, cứng cáp, và có thể giết người nếu cần thiết. Bất ngờ chưa dừng lại ở đó, cánh tay phải của tổ chức và cũng là người có tránh nhiệm chỉ huy đoàn xe ở Mĩ lại chính là Letty (Rodriguez) - người tưởng chừng như đã chết trong phần trước. Sau nhiều chiến dịch thất bại, Hobbs nhận ra rằng để đối phó với tổ chức này anh cần phải có một nhóm chuyên nghiệp hơn những cảnh sát mà anh đang có. Nhớ lại những người \"bạn\" tại Rio của mình, anh liên lạc và tập trung họ. Những người bạn bất ngờ hội tụ tại một nơi sau vài năm xa cách, Hobbs nói lên ý kiến của mình và đặt ra một phần thưởng không thể từ chối đó là toàn bộ số tiền thu được của tổ chức trong \"phi vụ\" này. Và như thế họ bắt tay và vẽ lên một ké hoạch để \"kiếm\" số tiền họ đang cần bấy lâu nay.', 1),
(11, 'The Man From Nowhere – Người Vô Danh Tính (2010)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/top-phim-hanh-dong-han-quoc-hay-nhat.jpg', 'Cha Tae-sik – một cựu đặc vụ chỉ sống một mình. Cuộc sống của anh bị sự cô độc bao vây bởi anh không có bạn. Anh chỉ có duy nhất một người bầu bạn, thường xuyên nói chuyện với mình là So-mi. Anh đặc biệt rất trân trọng cô bé này. \r\n\r\nMẹ của So-mi nghiện hút ma túy, cả hai mẹ con cùng chung sống gần nhà của anh. Cao trào của bộ phim diễn ra khi mẹ con cô bị bắt cóc khi cuộc mua bán ma túy của những kẻ đứng đầu đường dây bị Hyo-jeong phá hỏng. \r\n\r\nĐứng trước tình huống này, Cha Tae-sik không thể ngồi yên mà buộc phải quay lại sự nghiệp đặc vụ của mình. Liệu, anh có thể giải cứu thành công 2 mẹ con So-mi hay không? Một bộ phim hay đáng xem hứa hẹn mang đến cho bạn nhiều cảm xúc khó tả với những pha hành động giật gân đến thót tim. ', 1),
(12, 'Fabricated City – Thành Phố Ảo (2017', 70000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Nghet-tho-voi-nhung-bo-phim-hanh-dong-Han-Quoc-day-kich-tinh.jpg', 'Nếu bạn là một người thích chơi game và mê phim hành động Hàn Quốc thì Thành phố ảo là bộ phim không thể bỏ qua. Phim xoay quanh nhân vật Kwon Yu – một tay game chuyên nghiệp, là thủ lĩnh trong game. Trái ngược với vẻ hào nhoáng trong game, ngoài đời  Kwon Yu chỉ là một kẻ ăn bám.\r\n\r\nMột ngày nọ, khi đang chơi game trong quán net, anh phát hiện người bạn ra về và bỏ quên điện thoại tại quán. Lúc về, anh đã mang theo điện thoại để trả lại cho chủ nhân của nó. Thế nhưng, anh không thể nào ngờ đến, chủ nhân của chiếc điện thoại đó đã bị sát hại ngay hôm sau và anh chính là kẻ tình nghi số 1.\r\n\r\nAnh bị gán với tội danh giết người nhưng anh không thể nhớ được mình có thực sự làm điều ấy hay không. Mọi chứng cứ đều bất lợi cho anh và anh không thể nào kháng cáo. Chính đồng đội của của anh đã tìm ra những điểm khả nghi và tập hợp lại để cùng minh oan cho anh, tìm ra kẻ thủ ác đứng đằng sau chuyện này.', 1),
(13, 'Ác Nữ Báo Thù – The Villainess', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Phim-hanh-dong-Han-Quoc-2017.jpg', 'Sook-hee có một tuổi thơ vô cùng bất hạnh khi phải chính mắt nhìn thấy cha mình bị sát hại. Sau đó, cô được Lee Joong-sang cưu mang và trở thành đệ tử của lão đại ca này. Cô đã phải trải qua thời gian dài khắc nghiệt với nhiều bài huấn luyện đổ máu để trở thành một nữ sát thủ đúng nghĩa. \r\n\r\nCô nuôi hi vọng được báo thù cho cha của mình. Cô và đại ca Lee Joong-sang cùng huynh đệ trong băng đảng đã tham gia rất nhiều phi vụ. Phim mang đến cho khán giả nhiều cảnh quay đẹp mắt cùng những cảnh chém giết, rượt đuổi đầy máu me, bạo lực. ', 1),
(14, 'The Thieves – Đội Quân Siêu Trộm (2012)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Phim-hanh-dong-Han-Quoc-noi-troi-nam-2012.jpg', '5 tên siêu trộm kết hợp với siêu đạo chích Macao Park đã tạo nên một băng nhóm trộm vô cùng hoàn hảo. Với nhiều thủ đoạn tinh vi, 6 người này đã lên kế hoạch để trộm viên kim cương Giọt Lệ Thái Dương có giá trị khủng lên đến 20 triệu USD. \r\n\r\nTuy nhiên, họ không hề đồng lòng để trộm và chia chát viên kim cương đắt giá này. Mỗi người trong họ đều hướng đến một mục đích khác nhau, tạo nên sự kịch tính, bất ngờ và thú vị cho bộ phim. \r\n\r\nLiệu họ có thành công trong phi vụ lần này? Bộ phim bom tấn này có doanh thu rất cao, được đông đảo khán giả đón nhận. Thật đáng tiếc nếu bạn bỏ lỡ phim này.', 1),
(15, 'Train to Busan – Chuyến Tàu Sinh Tử (2016)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/05/top-phim-hanh-dong-han-quoc-hay-nhat.jpg', 'Bộ phim Chuyến Tàu Sinh Tử từng làm mưa làm gió một thời gian dài, được đông đảo khán giả yêu phim trên nhiều quốc gia yêu thích. Đây là bộ phim hành động giả tưởng, khi đất nước Hàn bị một loại virus gây bệnh xác sống bao quanh, khiến mảnh đất này tràn ngập xác sống và là mối đe dọa của bất cứ người nào.\r\n\r\nCó mặt trên chuyến tàu định mệnh mệnh đi từ ga Seoul đến Busan là những học sinh tuổi đời còn rất trẻ; đôi vợ chồng trẻ (người vợ đang mang thai) và hai cha con. Xác sống đã bao vây khắp nơi, buộc họ phải đương đầu với chúng để giành giật sự sống quý giá. \r\n\r\nPhim mang đến cho người xem nhiều cảm xúc, suy nghĩ về ranh giới giữa sự sống và cái chết, những cuộc chia ly đẫm nước mắt. Đây là một bộ phim hay, cảm động mà bạn nên xem ít nhất 1 lần.', 1),
(16, 'The Outlaws – Ngoài Vòng Pháp Luật (2017)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Phim-hanh-dong-Han-Quoc-voi-nhung-tinh-tiet-het-suc-gay-can.jpg', 'Ngoài Vòng Pháp Luật là bộ phim hành động vô cùng gay cấn, hấp dẫn, xoay quanh 2 băng đảng Garibong Hàn Quốc và Heuksapa của Trung Quốc. 2 băng đảng này đã có những cuộc tranh đấu, ẩu đã đầy khốc liệt liên quan đến việc cho vay nặng lãi.\r\n\r\nCuối cùng, cảnh sát Hàn Quốc đã vào cuộc để giải giải quyết chuyện này. Người đứng ra nhận nhiệm vụ đầy khó khăn này là Ma Dong Seok – sĩ quan người Hàn. Để có thể thành công, anh phải khôn khéo trong nhiều tình huống. Chính nhờ tài năng và bản lĩnh của mình, nhân vật do Ma Dong Seok thủ vai đã khiến 2 băng đảng trên ngã ngũ. \r\n\r\nNhững cảnh quay hành động trong phim được đánh giá cao, cảnh đấm đánh rất thật cùng nhiều tình huống dở khóc dở cười sẽ khiến bạn không thể rời mắt dù chỉ một phút. ', 1),
(17, 'Along With the Gods: The Two Worlds – Thử Thách Thần Chết: Giữa Hai Thế Giới (2017)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Phim-hanh-dong-Han-Quoc-voi-chu-de-moi-la.jpg', 'Bộ phim Thử Thách Thần Chết được đánh giá cao về nội dung lẫn kỹ thuật, kỹ xảo, mang đến bộ phim hành động đầy mãn nhãn. Phim chứa nhiều tình tiết thú vị với tình huống mới mẻ, khiến người xem không ngừng bị cuốn hút và phải liên tục chạy theo. Phim được đẩy lên cao trào và dần dần tháo gỡ các nút thắt, giúp người xem giải đáp những câu hỏi trong đầu. \r\n\r\nNhân vật chính trong phim là lính cứu hỏa Kim Ja Hong. Khi thực hiện nhiệm vụ cứu hỏa của mình, anh đã hi sinh. Linh hồn của anh được bảo vệ bởi 3 vị thần. Họ yêu cầu anh phải thực hiện 7 thử thách trong thời gian 49 ngày. Nếu thành công, anh sẽ được tái sinh. ', 2),
(18, 'Asura: The City of Madness – Thành Phố Tội Ác (2016)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Ranh-gioi-thien-va-ac-trong-phim-hanh-dong-Han-Quoc.jpg', 'Thành Phố Tội Ác là bộ phim hành động Hàn Quốc ăn khách của đạo diễn Kim Sung-su. Phim lấy bối cảnh tại một thành phố mà cái ác tại đây đã xâm chiếm và thắng thế. Từ thị trưởng thành phố cho đến điều tra viên đều có những hành vi đen tối nhằm che đậy các mối làm ăn bất chính ngay tại nơi mà họ lãnh đạo.\r\n\r\nĐến khi mọi việc bị phát giác bởi một công tố viên liêm chính, sự việc được đẩy lên cao trào với nhiều tình huống nghẹt thở. Ranh giới giữa thiện và ác trở nên mong manh khó tả. Liệu cuối cùng, thiện và ác, cái nào thắng thế?', 1),
(19, 'The Gangster, The Cop, The Devil – Trùm, Cớm Và Ác quỷ (2019)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Phim-hanh-dong-Han-Quoc-hay-nhat-2019.jpg', 'Sự kết hợp độc đáo giữa bộ 3: Một tay cảnh sát, một tên trùm khét tiếng và một kẻ sát nhân máu lạnh đã tạo nên những tình tiết vô cùng thú vị, gay cấn trong phim. Ông trùm này chính là mục tiêu tiếp theo của kẻ sát nhân.\r\n\r\nBị đẩy vào tình thế bắt buộc, ông trùm Jang Dong Su phải bắt tay hợp tác với cớm để bắt được tên sát nhân này. Tuy nhiên, giữa họ vẫn có những bí mật riêng và không thể để đối phương nắm được. Liệu câu chuyện sẽ đi về đâu?', 1),
(20, 'The Suspect – Truy Lùng (2013)', 50000, 'https://cdn.popsww.com/blog/sites/2/2021/12/Phim-hanh-dong-Han-Quoc-hap-dan.jpg', 'Bộ phim xoay quanh đặc vụ kì cựu Ji Dong Chul nhưng lại bị chính quốc gia mà mình từng cống hiến chối bỏ. Đau đớn hơn, vợ con của ông bị chính đồng nghiệp hãm hại. Để thực hiện mục đích trả thù, ông đã trở thành tài xế cho ông Park. \r\n\r\nTồi tệ hơn, ông Park bị sát hại dã man. Kỷ vật cuối cùng mà ông trao cho tài xế của mình là một đôi kính. Cũng từ món kỷ vật này, ông bị gán tội giết người và phải chạy trốn. Liệu ông sẽ làm gì để minh oan cho chính mình, hung thủ giết chủ tịch Park thực sự là ai? ', 1),
(21, 'Godzilla đại chiến Kong', 70000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPz_w9n4PLHbS0i7H90_29yMauTXNVBGcg4w&usqp=CAU', 'Bộ phim chiếu rạp bùng nổ các rạp phim tại Việt Nam trước khi mùa Covid năm 2021. Tác phẩm này ra đời sau các series phim về Godzilla và King Kong do Adam Wingard. Với những kỹ xảo tuyệt vời xứng danh của một bộ phim bom tấn với những trận chiến kinh hoàng giữa hai vị chúa tể khổng lồ khiến người xem không thể rời mắt.', 2),
(22, 'Liên minh công lý', 70000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-yZpc7BN7jgNhV8zJcP_zaAoVQOgrV9TH9A&usqp=CAU', 'Ngày 18/3, Zack Snyder’s Justice League sẽ chính thức trình làng người hâm mộ. Dù tương lai của “Snyderverse” trong Vũ trụ mở rộng DC (DCEU) vẫn còn là dấu hỏi lớn, sự ra đời của bản dựng vẫn rất đáng mong đợi và là món quà xứng đáng cho fan của DC - những người chắc chắn chưa thể thỏa mãn với bản phim 2017', 2),
(23, 'Loki', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTp-VP4G9SGq1HX4-AqxmmUHPYEQM-ptsNTQQ&usqp=CAU', 'Loki không bao giờ có phim riêng trong MCU bởi vì anh ấy chủ yếu được sử dụng như một nhân vật phản diện và đôi khi là trợ lý cho Thor. Tuy nhiên, anh ấy sẽ có được câu chuyện độc lập của riêng mình trong series mới nhờ vào nền tảng phát trực tuyến mới của Disney -Disney +.', 2),
(24, 'Ma trận 4', 50000, 'https://cdn.nguyenkimmall.com/images/companies/_1/tin-tuc/kinh-nghiem-meo-hay/C%C3%B4ng%20ngh%E1%BB%87/the-matrix1.jpg.jpg', 'Sau thành công của 3 phần trước, khán giả của Ma trận - The Matrix lại không khỏi ngạc nhiên vì sự trở lại một lần nữa của bộ phim này. Ở The Matrix 3 -  The Matrix Revolutions, hai nhân vật Neo và Trinity đều đã bị giết, tiếp nối phần này họ hồi sinh và tiếp tục đồng hành cùng nhau để chống lại những cỗ máy robot âm mưu thôn tính thế giới.', 2),
(25, 'Hố Đen Tử Thần - Interstellar (2014)', 50000, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNkyWM6lfHdjA4EBDOc05epPAUo_jz1L2DFA&usqp=CAU', 'Đây có lẽ là một bộ phim khoa học viễn tưởng về du hành vũ trụ hay nhất mà bạn từng xem. Một trong những điều mà mình hối hận nhất là đã không đi xem phim này ngoài rạp…Phim gì mà đỉnh thật sự. Phim như một nước đi táo bạo khi vẽ ra sự liên kết giữa sự tưởng chừng như là “cứng nhắc” của khoa học với sự gần gũi, ấm áp của tình cảm con người.', 2);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaiphim`
--
ALTER TABLE `loaiphim`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phim`
--
ALTER TABLE `phim`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `loaiphim`
--
ALTER TABLE `loaiphim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `phim`
--
ALTER TABLE `phim`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
