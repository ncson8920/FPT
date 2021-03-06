USE [master]
GO
/****** Object:  Database [TimeTable]    Script Date: 8/15/2021 10:41:07 PM ******/
CREATE DATABASE [TimeTable]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TimeTable', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\TimeTable.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TimeTable_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\TimeTable_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [TimeTable] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TimeTable].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [TimeTable] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [TimeTable] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [TimeTable] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [TimeTable] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [TimeTable] SET ARITHABORT OFF 
GO
ALTER DATABASE [TimeTable] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [TimeTable] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [TimeTable] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [TimeTable] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [TimeTable] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [TimeTable] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [TimeTable] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [TimeTable] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [TimeTable] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [TimeTable] SET  ENABLE_BROKER 
GO
ALTER DATABASE [TimeTable] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [TimeTable] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [TimeTable] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [TimeTable] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [TimeTable] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [TimeTable] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [TimeTable] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [TimeTable] SET RECOVERY FULL 
GO
ALTER DATABASE [TimeTable] SET  MULTI_USER 
GO
ALTER DATABASE [TimeTable] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [TimeTable] SET DB_CHAINING OFF 
GO
ALTER DATABASE [TimeTable] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [TimeTable] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [TimeTable] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'TimeTable', N'ON'
GO
USE [TimeTable]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 8/15/2021 10:41:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Class](
	[ClassID] [int] NOT NULL,
	[ClassName] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ClassID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Room]    Script Date: 8/15/2021 10:41:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room](
	[RoomID] [int] NOT NULL,
	[RoomName] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Teacher]    Script Date: 8/15/2021 10:41:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Teacher](
	[TeacherID] [int] NOT NULL,
	[TeacherName] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[TeacherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Time]    Script Date: 8/15/2021 10:41:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Time](
	[Slot] [int] NOT NULL,
	[Time] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Slot] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TimeTable]    Script Date: 8/15/2021 10:41:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TimeTable](
	[ClassID] [int] NOT NULL,
	[Date] [datetime] NOT NULL,
	[Slot] [int] NOT NULL,
	[RoomID] [int] NULL,
	[TeacherID] [int] NULL,
 CONSTRAINT [PK__TimeTabl__FBD6DBD9846A64EF] PRIMARY KEY CLUSTERED 
(
	[ClassID] ASC,
	[Date] ASC,
	[Slot] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (1, N'SE1401')
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (2, N'SE1402')
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (3, N'SE1403')
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (4, N'SE1404')
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (5, N'SE1405')
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (1, N'AL-201')
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (2, N'AL-202')
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (3, N'AL-203')
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (4, N'AL-204')
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (5, N'AL-205')
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (1, N'HungKD')
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (2, N'VinhTT')
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (3, N'ToanNM')
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (4, N'LongDT')
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (5, N'SonNC')
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName]) VALUES (6, N'BinhTV')
INSERT [dbo].[Time] ([Slot], [Time]) VALUES (1, N'7h30'' - 9h')
INSERT [dbo].[Time] ([Slot], [Time]) VALUES (2, N'9h10'' - 10h40''')
INSERT [dbo].[Time] ([Slot], [Time]) VALUES (3, N'10h50'' - 12h20''')
INSERT [dbo].[Time] ([Slot], [Time]) VALUES (4, N'12h50'' - 14h20''')
INSERT [dbo].[Time] ([Slot], [Time]) VALUES (5, N'14h30'' - 16h')
INSERT [dbo].[Time] ([Slot], [Time]) VALUES (6, N'16h10'' - 17h40''')
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-01-08 00:00:00.000' AS DateTime), 1, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-27 00:00:00.000' AS DateTime), 1, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-27 00:00:00.000' AS DateTime), 2, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-27 00:00:00.000' AS DateTime), 3, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-27 00:00:00.000' AS DateTime), 4, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-27 00:00:00.000' AS DateTime), 5, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-27 00:00:00.000' AS DateTime), 6, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-28 00:00:00.000' AS DateTime), 1, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-28 00:00:00.000' AS DateTime), 2, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-28 00:00:00.000' AS DateTime), 3, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-28 00:00:00.000' AS DateTime), 4, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-28 00:00:00.000' AS DateTime), 5, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-28 00:00:00.000' AS DateTime), 6, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-29 00:00:00.000' AS DateTime), 1, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-29 00:00:00.000' AS DateTime), 2, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-29 00:00:00.000' AS DateTime), 3, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-29 00:00:00.000' AS DateTime), 4, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-29 00:00:00.000' AS DateTime), 5, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-29 00:00:00.000' AS DateTime), 6, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-30 00:00:00.000' AS DateTime), 1, 1, 5)
INSERT [dbo].[TimeTable] ([ClassID], [Date], [Slot], [RoomID], [TeacherID]) VALUES (1, CAST(N'2021-07-30 00:00:00.000' AS DateTime), 2, 1, 5)
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK__TimeTable__Class__6FE99F9F] FOREIGN KEY([ClassID])
REFERENCES [dbo].[Class] ([ClassID])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK__TimeTable__Class__6FE99F9F]
GO
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK__TimeTable__RoomI__71D1E811] FOREIGN KEY([RoomID])
REFERENCES [dbo].[Room] ([RoomID])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK__TimeTable__RoomI__71D1E811]
GO
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK__TimeTable__Slot__70DDC3D8] FOREIGN KEY([Slot])
REFERENCES [dbo].[Time] ([Slot])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK__TimeTable__Slot__70DDC3D8]
GO
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK__TimeTable__Teach__72C60C4A] FOREIGN KEY([TeacherID])
REFERENCES [dbo].[Teacher] ([TeacherID])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK__TimeTable__Teach__72C60C4A]
GO
USE [master]
GO
ALTER DATABASE [TimeTable] SET  READ_WRITE 
GO
