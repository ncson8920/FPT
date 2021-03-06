USE [master]
GO
/****** Object:  Database [Photographer]    Script Date: 8/15/2021 10:36:23 PM ******/
CREATE DATABASE [Photographer]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Photographer', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Photographer.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Photographer_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\Photographer_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Photographer] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Photographer].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Photographer] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Photographer] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Photographer] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Photographer] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Photographer] SET ARITHABORT OFF 
GO
ALTER DATABASE [Photographer] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Photographer] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Photographer] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Photographer] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Photographer] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Photographer] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Photographer] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Photographer] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Photographer] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Photographer] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Photographer] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Photographer] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Photographer] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Photographer] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Photographer] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Photographer] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Photographer] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Photographer] SET RECOVERY FULL 
GO
ALTER DATABASE [Photographer] SET  MULTI_USER 
GO
ALTER DATABASE [Photographer] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Photographer] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Photographer] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Photographer] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Photographer] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Photographer', N'ON'
GO
USE [Photographer]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 8/15/2021 10:36:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Contact](
	[Address] [nvarchar](300) NULL,
	[City] [nvarchar](300) NULL,
	[Country] [nvarchar](300) NULL,
	[Phone] [varchar](20) NULL,
	[Email] [varchar](50) NULL,
	[About] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Gallery]    Script Date: 8/15/2021 10:36:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Gallery](
	[GalleryID] [int] NOT NULL,
	[GalleryName] [varchar](100) NULL,
	[Description] [text] NULL,
	[BigImage] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[GalleryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Image]    Script Date: 8/15/2021 10:36:23 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[ID] [int] NOT NULL,
	[GalleryID] [int] NULL,
	[image] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Contact] ([Address], [City], [Country], [Phone], [Email], [About]) VALUES (N'FPT University', N'Ha Noi', N'Viet Nam', N'024 7300 1866', N'daihocfpt@fpt.edu.vn', N'A professional photographer who works full-time often does studio work that involves taking pictures in a controlled interior setting, with professional or amateur models. These photographers can be freelance, or can also be kept on retainer by certain magazines and fashion companies.')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (1, N'Gallery 1', N'A photographer is a professional that focuses on the art of taking photographs with a digital or film camera. Photographers use artificial and/or natural lighting to snap pictures of various people, places and things in a variety of settings. Some photographers focus on studio work, while other explore the natural, outside world.', N'img1.jpg')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (2, N'Gallery 2', N'A photographer generally works in a freelance capacity, and is hired for specific jobs by numerous clients. Some photographers work exclusively in certain segments of the industry, such as wedding, graduation and other event-type settings, while others do mainly corporate work, and spend most of their time taking photographs that will appear on business websites and other promotional material.', N'img2.jpg')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (3, N'Gallery 3', N'A part-time or freelance photographer who is hired by a client is responsible for following the client''s wishes down to the finest details, as well as for setting up a business model that makes pricing and options clearly visible and accessible.', N'img3.jpg')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (4, N'Gallery 4', N'A professional photographer who works full-time often does studio work that involves taking pictures in a controlled interior setting, with professional or amateur models. These photographers can be freelance, or can also be kept on retainer by certain magazines and fashion companies.', N'img4.jpg')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (5, N'Gallery 5', N'A photographer is a professional that focuses on the art of taking photographs with a digital or film camera. Photographers use artificial and/or natural lighting to snap pictures of various people, places and things in a variety of settings. Some photographers focus on studio work, while other explore the natural, outside world.', N'img5.jpg')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (6, N'Gallery 6', N'A photographer generally works in a freelance capacity, and is hired for specific jobs by numerous clients. Some photographers work exclusively in certain segments of the industry, such as wedding, graduation and other event-type settings, while others do mainly corporate work, and spend most of their time taking photographs that will appear on business websites and other promotional material.', N'img6.jpg')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (7, N'Gallery 7', N'A part-time or freelance photographer who is hired by a client is responsible for following the client''s wishes down to the finest details, as well as for setting up a business model that makes pricing and options clearly visible and accessible.', N'img7.jpg')
INSERT [dbo].[Gallery] ([GalleryID], [GalleryName], [Description], [BigImage]) VALUES (8, N'Gallery 8', N'A professional photographer who works full-time often does studio work that involves taking pictures in a controlled interior setting, with professional or amateur models. These photographers can be freelance, or can also be kept on retainer by certain magazines and fashion companies.', N'img8.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (3, 1, N'img3.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (4, 1, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (5, 1, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (6, 1, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (7, 1, N'img2.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (8, 1, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (9, 1, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (10, 1, N'img6.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (11, 2, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (12, 2, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (13, 2, N'img8.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (14, 2, N'img6.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (15, 2, N'img2.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (16, 2, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (17, 2, N'img3.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (18, 2, N'img7.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (21, 3, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (22, 3, N'img7.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (23, 3, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (24, 3, N'img2.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (25, 3, N'img8.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (30, 5, N'img3.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (31, 4, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (32, 4, N'img3.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (33, 4, N'img7.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (34, 4, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (35, 4, N'img8.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (36, 4, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (40, 6, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (50, 7, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (60, 8, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (70, 5, N'img2.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (80, 6, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (90, 7, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (100, 8, N'img6.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (110, 5, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (120, 6, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (130, 7, N'img8.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (140, 8, N'img6.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (150, 5, N'img2.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (160, 6, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (170, 7, N'img3.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (180, 8, N'img7.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (210, 5, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (220, 6, N'img7.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (230, 7, N'img4.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (240, 8, N'img2.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (250, 5, N'img8.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (310, 6, N'img1.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (320, 7, N'img3.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (330, 8, N'img7.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (340, 5, N'img5.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (350, 6, N'img8.jpg')
INSERT [dbo].[Image] ([ID], [GalleryID], [image]) VALUES (360, 7, N'img4.jpg')
ALTER TABLE [dbo].[Image]  WITH CHECK ADD FOREIGN KEY([GalleryID])
REFERENCES [dbo].[Gallery] ([GalleryID])
GO
USE [master]
GO
ALTER DATABASE [Photographer] SET  READ_WRITE 
GO
