USE [master]
GO
/****** Object:  Database [DigitalNews]    Script Date: 8/15/2021 10:33:11 PM ******/
CREATE DATABASE [DigitalNews]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DigitalNews', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DigitalNews.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DigitalNews_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DigitalNews_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DigitalNews] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DigitalNews].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DigitalNews] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DigitalNews] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DigitalNews] SET ARITHABORT OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DigitalNews] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DigitalNews] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DigitalNews] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DigitalNews] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DigitalNews] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DigitalNews] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DigitalNews] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DigitalNews] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DigitalNews] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DigitalNews] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DigitalNews] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DigitalNews] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DigitalNews] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DigitalNews] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DigitalNews] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DigitalNews] SET RECOVERY FULL 
GO
ALTER DATABASE [DigitalNews] SET  MULTI_USER 
GO
ALTER DATABASE [DigitalNews] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DigitalNews] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DigitalNews] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DigitalNews] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [DigitalNews] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DigitalNews', N'ON'
GO
USE [DigitalNews]
GO
/****** Object:  Table [dbo].[news]    Script Date: 8/15/2021 10:33:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[news](
	[id] [int] NOT NULL,
	[title] [ntext] NOT NULL,
	[description] [ntext] NOT NULL,
	[summary] [ntext] NOT NULL,
	[image] [nvarchar](50) NOT NULL,
	[author] [nvarchar](50) NOT NULL,
	[timePost] [datetime] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (1, N'Intel to create new units for software, high-performance computing', N'Intel also said current executives Sandra Rivera and Raja Koduri will take on new senior leadership roles, while technology industry veterans Nick McKeown and Greg Lavender will join the company. Lavender, who most recently served as senior vice president and chief technology officer of VMware, will be the general manager of the new software and advanced technology group, while Koduri will lead an accelerated computing systems and graphics group.', N'Chipmaker Intel Corp (INTC.O) said on Tuesday it would create two new business units that would focus separately on software and high-performance computing and graphics.', N'i1.jpg', N'David Shepardson', CAST(N'2021-06-23 16:45:00.000' AS DateTime))
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (2, N'Facebook expands Shops to WhatsApp, Marketplace in commerce push', N'Facebook Chief Executive Mark Zuckerberg said it would also introduce personalized ads in its Shops service based on users shopping behavior. The social media giant, which launched Shops last year as a way for people to find and buy products on Facebook and Instagram as part of its push into ecommerce, said it has more than 300 million monthly Shops visitors and about 1.2 million monthly active Shops.', N'Facebook Inc (FB.O) is expanding its "Shops" feature to its messaging app WhatsApp in several countries and to Facebook Marketplace in the United States, the company said on Tuesday as it announced changes to its commerce tools.', N'i1.jpg', N'Tom Wilson', CAST(N'2021-06-23 03:00:00.000' AS DateTime))
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (3, N'Teamsters union steps up efforts to organize Amazon workers', N'Representatives from 500 unions, which together account for 1.4 million workers in the United States, have come together at the 30th international convention of Teamsters to support and help improve the livelihoods of Amazon workers. The union tweeted that delegates will vote on a resolution to make the campaign at Amazon a top priority. It is also planning pressure campaigns involving work stoppages, petitions and other collective action to push Amazon to bargain over working conditions and meet workers demands.', N'The International Brotherhood of Teamsters, a labor union in the United States and Canada, is stepping up efforts to unionize workers at Amazon.com Inc (AMZN.O) by creating a company-specific division to aid workers, it said on Tuesday.', N'i1.jpg', N'Alun John', CAST(N'2021-06-23 04:25:00.000' AS DateTime))
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (4, N'Bitcoin rallies after dropping below $30,000 on China crackdown', N'The world largest cryptocurrency dropped to $28,600, its lowest since early January. It was last up 3.7% at $32,802, and remains about 13% higher so far this year. Bitcoin earlier fall also pressured smaller coins such as ether . It tumbled 11% on Monday, its largest one-day drop in over a month, with losses of roughly 56% since hitting an all-time high of just under $65,000 in mid-April. The earlier sell-off was sparked by the People Bank of China urging China largest banks and payment firms to crack down harder on cryptocurrency trading, the latest tightening of restrictions on the sector by Beijing.', N'Bitcoin recovered from a five-month low on Tuesday in volatile session in which it fell below $30,000, extending losses sparked a day earlier when China central bank deepened a crackdown on cryptocurrencies.', N'i1.jpg', N'Raphael Satter', CAST(N'2021-06-22 02:40:00.000' AS DateTime))
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (5, N'Fortnite creator Epic Games touts over 500 million accounts', N'The videogame developer said it had 2.7 billion friend connections across "Fortnite", "Rocket League" and the Epic Games Store. The company had disclosed last year that "Fortnite" had 350 million registered users as of June 2020. Epic Games said it was also launching free voice chat and anti-cheat tools that developers can add to their games. The features will be bundled with Epic online services suite, originally built for "Fortnite", and help developers launch, operate and scale their games using any engine and across platforms including Windows, Mac, Linux, PlayStation and Xbox.', N' "Fortnite" creator Epic Games, which is entrenched in a legal battle with Apple Inc (AAPL.O), said on Tuesday it now has more than 500 million accounts.', N'i1.jpg', N'Eva Mathews', CAST(N'2021-06-22 13:00:00.000' AS DateTime))
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (6, N'Worst hackers avoid attacking Eastern European countries: reports', N'DarkSide, the criminal organization behind the Colonial Pipeline cyberattack, and other high-profile hacking groups bar their partners from installing malicious software on computers using certain languages, according to Krebs on Security, a cybersecurity news site. This has been going on since the early days of organized cybercrime, and "it is intended to minimize scrutiny and interference from local authorities," Krebs wrote as part of a post pointing out that certain malware will not install on a Microsoft Windows computer that has a Russian or Ukrainian virtual keyboard installed.', N'Some of the most notorious hackers steer clear of attacking organizations in Eastern European countries.', N'i1.jpg', N'Brooke Crothers', CAST(N'2021-06-21 19:20:00.000' AS DateTime))
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (7, N'Nga tung video giải thích lý do chặn tàu hải quân Hà Lan', N'Sự việc được cho là xảy ra vào ngày 24/6, một ngày sau khi tàu khu trục HMS Defender của Hải quân Hoàng gia Anh xâm phạm vùng biển nước Nga ngoài khơi Crimea và nhận những phát súng cảnh cáo từ các tàu tuần tra Nga. Bộ Quốc phòng Nga khẳng định: Trong khi được di chuyển tại vùng biển quốc tế, tàu HNLMS Evertsen đã chuyển hướng và bắt đầu di chuyển về Eo biển Kerch. Máy bay Su-30 và Su-24 đã được điều động để ngăn chặn hành vi xâm phạm vùng biển Nga. Họ bay ở khoảng cách an toàn và đã bay về căn cứ ngay khi tàu Hà Lan chuyển hướng. Các chuyến bay của máy bay Nga hoạt động tuân thủ quy định không phận quốc tế.Trước đó, Bộ Quốc phòng Hà Lan lên tiếng cáo buộc các máy bay Nga có những hành vi không an toàn. Trong một tuyên bố sáng 29/6, Bộ Quốc phòng Hà Lan cho biết máy bay Nga đã quấy rối tàu nước này tại vùng biển quốc tế trong 5 giờ đồng hồ ở khoảng cách gần sát đến mức nguy hiểm và thực hiện các cuộc tấn công mô phỏng.Bộ Quốc phòng Hà Lan giải thích tàu Evertsen là một phần trong nhóm tàu tấn công của Tổ chức Hiệp ước Bắc Đại Tây Dương (NATO) đang tham gia tập trận tại Biển Đen với các đồng minh khác trong khu vực.', N'Quan chức quốc phòng Nga ngày 29/6 thông báo nước này đã điều các chiến đấu cơ và máy bay ném bom theo sát một tàu hải quân Hà Lan sau khi nhận thấy tàu này đổi hướng nhằm về vùng biển của Nga.', N'i1.jpg', N'Bảo Hà', CAST(N'2021-06-30 12:00:00.000' AS DateTime))
INSERT [dbo].[news] ([id], [title], [description], [summary], [image], [author], [timePost]) VALUES (8, N'Hi hi HI hI, code khá đấy, khá đấy', N'Sáng 2/7, Ban chỉ đạo phòng, chống Covid-19 TP.HCM tổ chức họp giao ban trực tuyến về tình hình dịch bệnh diễn ra tại thành phố.

Báo cáo tại cuộc họp, Giám đốc Sở Y tế TP.HCM Nguyễn Tấn Bỉnh cho biết, tính từ ngày 27/4 đến 18h ngày 1/7, TP.HCM có 4.345 ca nhiễm trong cộng đồng được Bộ Y tế công bố. Trong đó, có 16 bệnh nhân đã tử vong.

Tính riêng từ 6h ngày 1/7 đến 6h ngày 2/7, thành phố ghi nhận 533 ca dương tính với nCoV. Trong đó, 460 trường hợp tại khu cách ly, khu phong tỏa, cách ly tại nhà đều xác định được nguồn nằm trong các chuỗi lây nhiễm trước đó; 2 trường hợp phơi nhiễm, là dân quân trực khu phòng tỏa ở quận 5 và TP Thủ Đức; 42 trường hợp phát hiện khi khám sàng lọc tại 15 bệnh viện.', N'TP.HCM có 4.345 ca mắc Covid-19, Thứ trưởng Bộ Y tế chỉ đạo khẩn', N'i1.jpg', N'Bảo Nam', CAST(N'2021-06-30 09:00:00.000' AS DateTime))
USE [master]
GO
ALTER DATABASE [DigitalNews] SET  READ_WRITE 
GO
